package edu.calc.becas.mcarga.hrs.blibioteca.api;

import edu.calc.becas.mcarga.hrs.ProcessFile;
import edu.calc.becas.mcarga.hrs.UploadFileAPI;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Marcos Santiago Leonardo
 * Universidad de la Sierra Sur (UNSIS)
 * Description: API para exponer servicios de carga de horas de biblioteca
 * Date: 5/4/19
 */
@RestController
@RequestMapping("/hrs-library")
@Api(description = "Servicios para carga de horas de biblioteca")
public class UploadFileLibraryAPI extends UploadFileAPI {

    @Autowired
    public UploadFileLibraryAPI(@Qualifier("cargaHrsBibliotecaService") ProcessFile processFile) {
        super.processFile = processFile;
    }
}
