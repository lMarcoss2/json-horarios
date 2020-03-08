package edu.calc.json.horarios.reporte.percent.beca.api;

import edu.calc.json.horarios.common.model.Pageable;
import edu.calc.json.horarios.common.model.WrapperData;
import edu.calc.json.horarios.reporte.percent.beca.model.ReporteActividad;
import edu.calc.json.horarios.reporte.percent.beca.service.ReportPercentBecaService;
import edu.calc.json.horarios.common.utils.Constant;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Marcos Santiago Leonardo
 * Universidad de la Sierra Sur (UNSIS)
 * Description:
 * Date: 2019-06-16
 */
@RestController
@RequestMapping("/reporte-detallado")
@Api(description = "Servicios para consultar reporte de porcentajes de becas")
public class ReportPercentBecaAPI {

    private final ReportPercentBecaService reportPercentBecaService;

    public ReportPercentBecaAPI(ReportPercentBecaService reportPercentBecaService) {
        this.reportPercentBecaService = reportPercentBecaService;
    }

    @GetMapping
    @ApiOperation(value = "Obtiene el reporte detallado de actividades")
    public WrapperData getAll(
            @ApiParam(value = "Página a recuperar", defaultValue = Constant.DEFAULT_PAGE) @RequestParam(value = "page", defaultValue = Constant.DEFAULT_PAGE, required = false) String page,
            @ApiParam(value = "Registros a recuperar", defaultValue = Constant.ALL_ITEMS) @RequestParam(value = "pageSize", defaultValue = Constant.ALL_ITEMS, required = false) String pageSize,
            @ApiParam(value = "Ciclo escolar a recuperar", defaultValue = Constant.ALL_ITEMS) @RequestParam(value = "ciclo-escolar", defaultValue = Constant.ALL_ITEMS, required = false) String cicloEscolar,
            @ApiParam(value = "Licenciatura a recuperar", defaultValue = Constant.ALL_ITEMS) @RequestParam(value = "licenciatura", defaultValue = Constant.ALL_ITEMS, required = false) String licenciatura,
            @ApiParam(value = "Grupo a recuperar", defaultValue = Constant.ALL_ITEMS) @RequestParam(value = "grupo", defaultValue = Constant.ALL_ITEMS, required = false) String grupo,
            @ApiParam(value = "Parcial a recuperar", defaultValue = Constant.ALL_ITEMS) @RequestParam(value = "parcial", defaultValue = Constant.ALL_ITEMS, required = false) String parcial,
            @ApiParam(value = "Actividad a recuperar", defaultValue = Constant.ALL_ITEMS) @RequestParam(value = "actividad", defaultValue = Constant.ALL_ITEMS, required = false) String actividad,
            @ApiParam(value = "Palabra clave") @RequestParam(value = "palabra-clave", defaultValue = "", required = false) String palabraClave
    ) {
        if (pageSize.equalsIgnoreCase(Constant.ALL_ITEMS)) {
            pageSize = Constant.ITEMS_FOR_PAGE;
        }
        Pageable pageable = new Pageable(Integer.parseInt(page), Integer.parseInt(pageSize));

        ReporteActividad reporte = defineFilterParam(cicloEscolar, licenciatura, grupo, parcial, actividad, palabraClave);

        return this.reportPercentBecaService.getAll(pageable, reporte);
    }

    private ReporteActividad defineFilterParam(String cicloEscolar, String licenciatura, String grupo, String parcial, String actividad, String palabraClave) {
        ReporteActividad filter = new ReporteActividad();

        if (cicloEscolar.equalsIgnoreCase(Constant.ALL_ITEMS)) {
            filter.setIdCicloEscolar(0);
        } else {
            filter.setIdCicloEscolar(Integer.parseInt(cicloEscolar));
        }

        if (licenciatura.equalsIgnoreCase(Constant.ALL_ITEMS)) {
            filter.setIdLicenciatura(0);
        } else {
            filter.setIdLicenciatura(Integer.parseInt(licenciatura));
        }

        if (grupo.equalsIgnoreCase(Constant.ALL_ITEMS)) {
            filter.setIdGrupo(0);
        } else {
            filter.setIdGrupo(Integer.parseInt(grupo));
        }

        if (parcial.equalsIgnoreCase(Constant.ALL_ITEMS)) {
            filter.setIdParcial(0);
        } else {
            filter.setIdParcial(Integer.parseInt(parcial));
        }

        if (actividad.equalsIgnoreCase(Constant.ALL_ITEMS)) {
            filter.setIdActividad(0);
        } else {
            filter.setIdActividad(Integer.parseInt(actividad));
        }

        if (!palabraClave.equalsIgnoreCase("")) {
            filter.setPalabraClave(palabraClave);
        }
        return filter;
    }
}
