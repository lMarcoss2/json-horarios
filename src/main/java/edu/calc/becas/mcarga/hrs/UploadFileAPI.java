package edu.calc.becas.mcarga.hrs;

import edu.calc.becas.mcarga.hrs.blibioteca.model.ProcessedFile;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author Marcos Santiago Leonardo
 * Universidad de la Sierra Sur (UNSIS)
 * Description:
 * Date: 5/4/19
 */

public class UploadFileAPI {

    @PostMapping("/upload")
    public ProcessedFile uploadFactura(@RequestParam("file") MultipartFile file) {
        System.out.println(file.getOriginalFilename());
        return ProcessedFile.builder()
                .error(false)
                .file(file.getOriginalFilename())
                .message(null)
                .idFile(1)
                .build();

    }
}
