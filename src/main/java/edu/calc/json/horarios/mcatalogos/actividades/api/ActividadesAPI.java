package edu.calc.json.horarios.mcatalogos.actividades.api;

import edu.calc.json.horarios.common.model.LabelValueData;
import edu.calc.json.horarios.common.model.WrapperData;
import edu.calc.json.horarios.exceptions.GenericException;
import edu.calc.json.horarios.mcatalogos.actividades.model.ActividadVo;
import edu.calc.json.horarios.mcatalogos.actividades.model.DetalleActividadVo;
import edu.calc.json.horarios.mcatalogos.actividades.service.ActividadesService;
import edu.calc.json.horarios.mconfiguracion.cicloescolar.model.CicloEscolarVo;
import edu.calc.json.horarios.mconfiguracion.cicloescolar.service.CicloEscolarService;
import edu.calc.json.horarios.common.utils.Constant;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/actividades")
@Api(description = "Servicios para administración de Actividades Extracurriculares")
public class ActividadesAPI {
    private final ActividadesService actividadesService;
    private final CicloEscolarService cicloEscolarService;

    @Autowired
    public ActividadesAPI(ActividadesService actividadesService, CicloEscolarService cicloEscolarService) {
        this.actividadesService = actividadesService;
        this.cicloEscolarService = cicloEscolarService;
    }

    @GetMapping
    @ApiOperation(value = "Obtiene el listado de Actividades")
    public WrapperData getAll(
            @ApiParam(value = "Página a recuperar", defaultValue = Constant.DEFAULT_PAGE)
            @RequestParam(value = "page", defaultValue = Constant.DEFAULT_PAGE, required = false) String page,
            @ApiParam(value = "Registros a recuperar", defaultValue = Constant.ALL_ITEMS)
            @RequestParam(value = "pageSize", defaultValue = Constant.ALL_ITEMS, required = false) String pageSize,
            @ApiParam(value = "Estatus de los registros a recuperar", defaultValue = Constant.DEFAULT_ESTATUS)
            @RequestParam(value = "status", defaultValue = Constant.DEFAULT_ESTATUS, required = false) String status) {

        if (pageSize.equalsIgnoreCase(Constant.ALL_ITEMS)) {
            pageSize = Constant.ITEMS_FOR_PAGE;
        }
        return actividadesService.getAllByStatus(Integer.parseInt(page), Integer.parseInt(pageSize), status);
    }


    @GetMapping("/detalle")
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
            @RequestParam(value = "username", defaultValue = Constant.ALL_ITEMS, required = false) String username) {

        if (pageSize.equalsIgnoreCase(Constant.ALL_ITEMS)) {
            pageSize = Constant.ITEMS_FOR_PAGE;
        }
        return actividadesService.getAllDetalle(Integer.parseInt(page), Integer.parseInt(pageSize), idActividad, idCiclo, status, username);
    }

    @PutMapping
    public ActividadVo modifyActividad(@ApiParam(value = "Detalle de hora para una actividad", defaultValue = "0") @RequestBody ActividadVo detalle) {
        detalle.setActualizadoPor("admin");
        return actividadesService.update(
                detalle
        );
    }


    @GetMapping("/list")
    public List<LabelValueData> getActividades() {
        return actividadesService.getActividades();
    }

    @PostMapping
    @ApiOperation(value = "Registra una nueva Actividad")
    public ActividadVo add(@ApiParam(value = "Actividad a registrar", defaultValue = "0") @RequestBody ActividadVo actividad) {
        actividad.setAgregadoPor("Admin");
        return actividadesService.add(actividad);
    }

    @PostMapping("/detallehoras")
    public DetalleActividadVo add(@ApiParam(value = "Detalle de hora para una actividad", defaultValue = "0") @RequestBody DetalleActividadVo detalle) throws Exception {
        detalle.setAgregadoPor("admin");
        try {
            CicloEscolarVo cicloEscolarVo  = new CicloEscolarVo();
            cicloEscolarVo = cicloEscolarService.getCicloEscolarActual();

            detalle.setIdCicloEscolar(cicloEscolarVo.getClave());
            detalle.setCicloEscolar(cicloEscolarVo.getNombre());

            return actividadesService.add(
                    detalle
            );
        } catch (Exception e) {
            e.printStackTrace();
            throw new GenericException(e);
        }

    }

    @PutMapping("/detallehoras")
    public DetalleActividadVo modify(@ApiParam(value = "Detalle de hora para una actividad", defaultValue = "0") @RequestBody DetalleActividadVo detalle) {
        detalle.setActualizadoPor("admin");
        return actividadesService.udateDetail(
                detalle
        );
    }
}
