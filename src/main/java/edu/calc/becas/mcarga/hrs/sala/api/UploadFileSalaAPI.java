package edu.calc.becas.mcarga.hrs.sala.api;

import edu.calc.becas.mcarga.hrs.ProcessHoursService;
import edu.calc.becas.mcarga.hrs.UploadFileAPI;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Marcos Santiago Leonardo
 * Universidad de la Sierra Sur (UNSIS)
 * Description: API para exponer servicios de carga de horas de sala de cómputo
 * Date: 3/06/19
 */
@RestController
@RequestMapping("/hrs-sala")
@Api(description = "Servicios para carga de horas de sala de cómputo")
public class UploadFileSalaAPI extends UploadFileAPI {

    @Autowired
    public UploadFileSalaAPI(@Qualifier("cargaHrsSalaService") ProcessHoursService processHoursService) {
        super.processHoursService = processHoursService;
    }
}
