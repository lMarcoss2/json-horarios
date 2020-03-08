package edu.calc.json.horarios.mcarga.hrs;

import edu.calc.json.horarios.common.model.CommonData;
import edu.calc.json.horarios.exceptions.GenericException;
import edu.calc.json.horarios.mcarga.hrs.read.files.ReadFile;
import edu.calc.json.horarios.mcarga.hrs.read.files.model.ProcessedFile;
import edu.calc.json.horarios.mconfiguracion.cicloescolar.model.CicloEscolarVo;
import edu.calc.json.horarios.mconfiguracion.cicloescolar.service.CicloEscolarService;
import edu.calc.json.horarios.mconfiguracion.parciales.model.Parcial;
import edu.calc.json.horarios.mconfiguracion.parciales.service.ParcialService;
import io.swagger.annotations.ApiOperation;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import static edu.calc.json.horarios.common.utils.Message.MESSAGE_ROWS_PROCESSED_ROOM_COMPUTER;
import static edu.calc.json.horarios.utils.ExtensionFile.XLSX_EXTENSION;
import static edu.calc.json.horarios.utils.ExtensionFile.XLS_EXTENSION;

/**
 * @author Marcos Santiago Leonardo
 * Universidad de la Sierra Sur (UNSIS)
 * Description: api genérico para cargar y guardar archivo
 * Date: 5/4/19
 */

public class UploadFileAPI {

    protected ProcessHoursService processHoursService;
    @Autowired
    private CicloEscolarService cicloEscolarService;
    @Autowired
    private ParcialService parcialService;

    @Value("${location.file}")
    String locationFile;

    @PostMapping("/upload")
    @ApiOperation(value = "Carga de archivo")
    public ProcessedFile uploadFactura(@RequestParam("file") MultipartFile file) throws GenericException {
        String pathfile = saveFile(file);
        Workbook pages = ReadFile.pages(pathfile);
        CommonData commonData = new CommonData();
        commonData.setAgregadoPor("ADMIN");
        commonData.setActualizadoPor("ADMIN");
        Parcial parcialActual = parcialService.getParcialActual();
        CicloEscolarVo cicloEscolarActual = cicloEscolarService.getCicloEscolarActual();

        int resultProcessed = processHoursService.processData(pages, commonData, parcialActual, cicloEscolarActual);
        return ProcessedFile.builder()
                .error(false)
                .file(pathfile)
                .message(String.format(MESSAGE_ROWS_PROCESSED_ROOM_COMPUTER, resultProcessed))
                .idFile(1)
                .build();

    }

    private String saveFile(MultipartFile file) throws GenericException {
        String nameFile = createNameFile(file.getOriginalFilename());
        try {
            byte[] bytes = file.getBytes();
            Path path = Paths.get(locationFile + nameFile);
            Files.write(path, bytes);
            return path.toString();
        } catch (IOException e) {
            throw new GenericException(e);
        }
    }

    private String createNameFile(String originalFilename) {
        Date date = Calendar.getInstance().getTime();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd-HH:mm:ss");
        String strDate = dateFormat.format(date);

        String nameFile;

        if (originalFilename.toUpperCase().endsWith(XLSX_EXTENSION)) {
            nameFile = originalFilename.toUpperCase().replace(XLSX_EXTENSION, "");
            return nameFile.replace(" ", "_") + strDate + XLSX_EXTENSION;
        } else {
            nameFile = originalFilename.toUpperCase().replace(XLS_EXTENSION, "");
            return nameFile.replace(" ", "_") + strDate + XLS_EXTENSION;
        }

    }

}
