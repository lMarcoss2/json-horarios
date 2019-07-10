package edu.calc.becas.reporte.percent.beca.api;

import edu.calc.becas.common.model.WrapperData;
import edu.calc.becas.reporte.percent.beca.service.ReportPercentBecaService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import static edu.calc.becas.common.utils.Constant.*;
import static edu.calc.becas.common.utils.Constant.ITEMS_FOR_PAGE;

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
            @ApiParam(value = "Página a recuperar", defaultValue = DEFAULT_PAGE) @RequestParam(value = "page", defaultValue = DEFAULT_PAGE, required = false) String page,
            @ApiParam(value = "Registros a recuperar", defaultValue = ALL_ITEMS) @RequestParam(value = "pageSize", defaultValue = ALL_ITEMS, required = false) String pageSize,
            @ApiParam(value = "Estatus de los registros a recuperar", defaultValue = DEFAULT_ESTATUS) @RequestParam(value = "status", defaultValue = DEFAULT_ESTATUS, required = false) String status,
            @ApiParam(value = "Tipo de usuario a recuperar", defaultValue = TIPO_USUARIO_DEFAULT) @RequestParam(value = "tipo-usuario", defaultValue = TIPO_USUARIO_DEFAULT, required = false) String tipoUsuario) {
        if (pageSize.equalsIgnoreCase(ALL_ITEMS)) {
            pageSize = ITEMS_FOR_PAGE;
        }
        return this.reportPercentBecaService.getAll(Integer.parseInt(page), Integer.parseInt(pageSize));
    }
}
