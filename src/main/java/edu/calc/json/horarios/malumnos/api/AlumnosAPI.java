package edu.calc.json.horarios.malumnos.api;

import edu.calc.json.horarios.common.model.WrapperData;
import edu.calc.json.horarios.malumnos.model.Alumno;
import edu.calc.json.horarios.malumnos.service.AlumnosService;
import edu.calc.json.horarios.common.utils.Constant;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/alumnos")
@Api(description = "Servicios para administración de Inscripcion de alumnos a Actividades ")
public class AlumnosAPI {

    private final AlumnosService alumnosService;

    @Autowired
    public AlumnosAPI(AlumnosService alumnosService) {
        this.alumnosService = alumnosService;
    }

    @GetMapping
    @ApiOperation(value = "Obtiene el listado de alumnos")
    public WrapperData getAll(
            @ApiParam(value = "Página a recuperar", defaultValue = Constant.DEFAULT_PAGE)
            @RequestParam(value = "page", defaultValue = Constant.DEFAULT_PAGE, required = false) String page,
            @ApiParam(value = "Registros a recuperar", defaultValue = Constant.ALL_ITEMS)
            @RequestParam(value = "pageSize", defaultValue = Constant.ALL_ITEMS, required = false) String pageSize,
            @ApiParam(value = "Estatus de los registros a recuperar", defaultValue = Constant.DEFAULT_ESTATUS)
            @RequestParam(value = "status", defaultValue = Constant.DEFAULT_ESTATUS, required = false) String status,
            @ApiParam(value = "Id de la actividad a la que perteneco el alumno", defaultValue = Constant.DEFAULT_ESTATUS)
            @RequestParam(value = "actividad", defaultValue = Constant.DEFAULT_ESTATUS, required = false) String actividad) {

        if (pageSize.equalsIgnoreCase(Constant.ALL_ITEMS)) {
            pageSize = Constant.ITEMS_FOR_PAGE;
        }

        return alumnosService.getAllByStatusAndOneParam(Integer.parseInt(page), Integer.parseInt(pageSize), status, actividad);
    }

    @PostMapping("/actividades")
    @ApiOperation(value = "Inserta un alumno con su actividad en la base de datos")
    public Alumno add(@ApiParam(value = "Realiza el insert a la tabla de alumnos y actividades", defaultValue = "0") @RequestBody Alumno alumno){
        alumnosService.add(alumno);
        return alumno;
    }


    /*
  public DetalleActividadVo add(@ApiParam(value = "Detalle de hora para una actividad", defaultValue = "0") @RequestBody DetalleActividadVo detalle){
        return  actividadesService.add(
                detalle
        );
    }
*/
}
