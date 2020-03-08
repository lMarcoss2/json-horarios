package edu.calc.json.horarios.mcarga.hrs.read.files;

import edu.calc.json.horarios.exceptions.GenericException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;

/**
 * @author Marcos Santiago Leonardo
 * Universidad de la Sierra Sur (UNSIS)
 * Description:
 * Date: 5/13/19
 */
public class ReadFile {
    private static final Logger LOG = LoggerFactory.getLogger(ReadFile.class);

    public static Workbook pages(String pathfile) throws GenericException {
        Workbook workbook = null;
        try {
            workbook = WorkbookFactory.create(new File(pathfile));
        } catch (IOException | InvalidFormatException e) {
            e.printStackTrace();
            throw new GenericException(e);
        }

        System.out.println("SHEETS: " + workbook.getNumberOfSheets());

        return workbook;
        /*// Leer hojas o sábanas del excel
        for (Sheet sheet : workbook) {
            LOG.info("HOJA:  "+ sheet.getSheetName());
        }

        // leer primer hoja
        Sheet sheet = workbook.getSheetAt(0);

        // filas de una hola
        List<RowFile> rows = new ArrayList<>();
        for (Row row : sheet) {

            RowFile rowFile = new RowFile();

            List<CellFile> cells = new ArrayList<>();

            for (Cell cell : row) {
                CellFile cellFile = new CellFile();
                String value = readCellByType(cell);
                if (value != null && !value.trim().equalsIgnoreCase("") && value.length() > 0) {
                    cellFile.setValue(
                            value.trim()
                    );

                    cells.add(cellFile);
                }


            }
            if (!cells.isEmpty() && cells.size() > 8) {
                rowFile.setCells(cells);
                rows.add(rowFile);
            }

        }

        List<Alumno> alumnos = new ArrayList<>();
        for (RowFile row : rows) {
            Alumno alumno = new Alumno();
            for (int i = 0; i < posEndCell; i++) {
                if (i == posMatricula) {
                    alumno.setMatricula(row.getCells().get(i).getValue());
                }

                if (i == posNombre) {
                    alumno.setNombres(row.getCells().get(i).getValue());
                }

                if (i == posHrs) {
                    alumno.setHrs(row.getCells().get(i).getValue());
                }
            }
            alumnos.add(alumno);
        }

        return alumnos;*/
    }
}
