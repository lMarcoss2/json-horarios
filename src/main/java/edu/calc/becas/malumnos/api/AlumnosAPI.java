package edu.calc.becas.malumnos.api;

import edu.calc.becas.common.model.WrapperData;
import edu.calc.becas.malumnos.service.AlumnosService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import static edu.calc.becas.common.utils.Constant.*;


@RestController
@RequestMapping("/alumnos")
@Api(description = "Servicios para administración de Inscripcion de alumnos a Actividades ")
public class AlumnosAPI {

    private  final AlumnosService alumnosService;

    @Autowired
    public AlumnosAPI(AlumnosService alumnosService) {
        this.alumnosService = alumnosService;
    }

    @GetMapping
    @ApiOperation(value = "Obtiene el listado de Actividades")
    public WrapperData getAll(
            @ApiParam(value = "Página a recuperar", defaultValue = DEFAULT_PAGE)
            @RequestParam(value = "page", defaultValue = DEFAULT_PAGE, required = false) String page,
            @ApiParam(value = "Registros a recuperar", defaultValue = ALL_ITEMS)
            @RequestParam(value = "pageSize", defaultValue = ALL_ITEMS, required = false) String pageSize,
            @ApiParam(value = "Estatus de los registros a recuperar", defaultValue = ESTATUS_DEFAULT)
            @RequestParam(value = "status", defaultValue = ESTATUS_DEFAULT, required = false) String status,
            @ApiParam(value = "Id de la actividad a la que perteneco el alumno", defaultValue = ESTATUS_DEFAULT)
            @RequestParam(value = "actividad", defaultValue = ESTATUS_DEFAULT, required = false) String actividad){

        if (pageSize.equalsIgnoreCase(ALL_ITEMS)) {
            pageSize = ITEMS_FOR_PAGE;
        }

        return alumnosService.getAll(Integer.parseInt(page), Integer.parseInt(pageSize), status, actividad);
    }

}
