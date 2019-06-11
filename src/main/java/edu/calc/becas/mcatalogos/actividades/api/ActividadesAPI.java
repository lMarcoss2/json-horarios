package edu.calc.becas.mcatalogos.actividades.api;

import edu.calc.becas.common.model.WrapperData;
import edu.calc.becas.mcatalogos.actividades.model.ActividadVo;
import edu.calc.becas.mcatalogos.actividades.service.ActividadesService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import static edu.calc.becas.common.utils.Constant.*;

@RestController
@RequestMapping("/actividades")
@Api(description = "Servicios para administración de Actividades Extracurriculares")
public class ActividadesAPI {
    private final ActividadesService actividadesService;

    @Autowired
    public ActividadesAPI(ActividadesService actividadesService){this.actividadesService = actividadesService;}

    @GetMapping
    @ApiOperation(value = "Obtiene el listado de Actividades")
    public WrapperData getAll(
            @ApiParam(value = "Página a recuperar", defaultValue = DEFAULT_PAGE)
            @RequestParam(value = "page", defaultValue = DEFAULT_PAGE, required = false) String page,
            @ApiParam(value = "Registros a recuperar", defaultValue = ALL_ITEMS)
            @RequestParam(value = "pageSize", defaultValue = ALL_ITEMS, required = false) String pageSize,
            @ApiParam(value = "Estatus de los registros a recuperar", defaultValue = ESTATUS_DEFAULT)
            @RequestParam(value = "status", defaultValue = ESTATUS_DEFAULT, required = false) String status){

            if (pageSize.equalsIgnoreCase(ALL_ITEMS)) {
                pageSize = ITEMS_FOR_PAGE;
            }
        return actividadesService.getAll(Integer.parseInt(page), Integer.parseInt(pageSize), status);
    }



    @GetMapping("/detalle")
    @ApiOperation(value = "Obtiene el detalle de las actividades")
    public WrapperData getAll(
            @ApiParam(value = "Página a recuperar", defaultValue = DEFAULT_PAGE)
            @RequestParam(value = "page", defaultValue = DEFAULT_PAGE, required = false) String page,
            @ApiParam(value = "Registros a recuperar", defaultValue = ALL_ITEMS)
            @RequestParam(value = "pageSize", defaultValue = ALL_ITEMS, required = false) String pageSize,
            @ApiParam(value = "Estatus de los registros a recuperar", defaultValue = ESTATUS_DEFAULT)
            @RequestParam(value = "status", defaultValue = ESTATUS_DEFAULT, required = false) String status,
            @ApiParam(value = "Identificador de la actividad a recuperar el detalle", defaultValue = ESTATUS_DEFAULT)
            @RequestParam(value = "actividad", defaultValue = ESTATUS_DEFAULT, required = false) String idActividad,
            @ApiParam(value = "Identificador del ciclo escolar asociado a la actividad", defaultValue = ESTATUS_DEFAULT)
            @RequestParam(value = "ciclo", defaultValue = ESTATUS_DEFAULT, required = false) String idCiclo){

        if (pageSize.equalsIgnoreCase(ALL_ITEMS)) {
            pageSize = ITEMS_FOR_PAGE;
        }
        return actividadesService.getAllDetalle(Integer.parseInt(page), Integer.parseInt(pageSize), idActividad, idCiclo);
    }


    @PostMapping
    @ApiOperation(value = "Registra una nueva Actividad")
    public ActividadVo add(@ApiParam(value = "Actividad a registrar", defaultValue = "0") @RequestBody ActividadVo actividad){
        actividad.setActualizadoPor("Admin");
        return actividadesService.add(actividad);
    }
}
