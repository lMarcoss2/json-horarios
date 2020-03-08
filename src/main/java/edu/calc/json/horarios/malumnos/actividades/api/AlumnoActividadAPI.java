package edu.calc.json.horarios.malumnos.actividades.api;

import edu.calc.json.horarios.common.model.WrapperData;
import edu.calc.json.horarios.exceptions.GenericException;
import edu.calc.json.horarios.malumnos.actividades.service.AlumnoActividadService;
import edu.calc.json.horarios.mcatalogos.actividades.model.ActividadVo;
import edu.calc.json.horarios.mconfiguracion.cicloescolar.service.CicloEscolarService;
import edu.calc.json.horarios.common.utils.Constant;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

/**
 * @author Marcos Santiago Leonardo
 * Universidad de la Sierra Sur (UNSIS)
 * Description: Api para exponer servicios de consulta de actividades por alumno(s)
 * Date: 2019-06-16
 */
@RestController
@RequestMapping()
public class AlumnoActividadAPI {

    private final AlumnoActividadService alumnoActividadService;
    private CicloEscolarService cicloEscolarService;

    public AlumnoActividadAPI(AlumnoActividadService alumnoActividadService, CicloEscolarService cicloEscolarService) {
        this.alumnoActividadService = alumnoActividadService;
        this.cicloEscolarService = cicloEscolarService;
    }

    @GetMapping("/alumnos/{matricula}/actividades")
    public ActividadVo getActividadByAlumno(@PathVariable String matricula) throws GenericException {
        return alumnoActividadService.getActividadByAlumno(matricula, cicloEscolarService.getCicloEscolarActual());
    }

    @GetMapping("/alumnos/actividades")
    @ApiOperation(value = "Obtiene el listado de horarios de las actividades")
    public WrapperData getAll(
      @ApiParam(value = "Página a recuperar", defaultValue = Constant.DEFAULT_PAGE)
      @RequestParam(value = "page", defaultValue = Constant.DEFAULT_PAGE, required = false) String page,

      @ApiParam(value = "Registros a recuperar", defaultValue = Constant.ALL_ITEMS)
      @RequestParam(value = "pageSize", defaultValue = Constant.ALL_ITEMS, required = false) String pageSize,

      @ApiParam(value = "Estatus de los registros a recuperar", defaultValue = Constant.DEFAULT_ESTATUS)
      @RequestParam(value = "status", defaultValue = Constant.DEFAULT_ESTATUS, required = false) String status,

      @ApiParam(value = "Identificador de la actividad a recuperar el detalle", defaultValue = Constant.ALL_ITEMS)
      @RequestParam(value = "actividad", defaultValue = Constant.ALL_ITEMS, required = false) String idActividad,

      @ApiParam(value = "Identificador del ciclo escolar asociado a la actividad", defaultValue = Constant.DEFAULT_ESTATUS)
      @RequestParam(value = "ciclo", defaultValue = Constant.DEFAULT_ESTATUS, required = false) String idCiclo,

      @ApiParam(value = "Encargado de la actividad", defaultValue = Constant.ALL_ITEMS)
      @RequestParam(value = "username", defaultValue = Constant.ALL_ITEMS, required = false) String username){

      if (pageSize.equalsIgnoreCase(Constant.ALL_ITEMS)) {
        pageSize = Constant.ITEMS_FOR_PAGE;
      }
      return alumnoActividadService.getAllAlumnosByActividad(Integer.parseInt(page), Integer.parseInt(pageSize), idActividad, idCiclo);
    }

}
