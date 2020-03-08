package edu.calc.json.horarios.mcatalogos.grupos.api;

import edu.calc.json.horarios.common.model.WrapperData;
import edu.calc.json.horarios.mcatalogos.grupos.service.GrupoService;
import edu.calc.json.horarios.common.utils.Constant;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Marcos Santiago Leonardo
 * Universidad de la Sierra Sur (UNSIS)
 * Description: API for groups
 * Date: 3/26/19
 */
@RestController
@RequestMapping("/grupos")
@Api(description = "Servicios para administración de grupos")
public class GrupoAPI {

    private final GrupoService grupoService;

    @Autowired
    public GrupoAPI(GrupoService grupoService) {
        this.grupoService = grupoService;
    }

    @GetMapping
    @ApiOperation(value = "Obtiene el listado de grupos")
    public WrapperData getAll(
            @ApiParam(value = "Página a recuperar", defaultValue = Constant.DEFAULT_PAGE) @RequestParam(value = "page", defaultValue = Constant.DEFAULT_PAGE, required = false) String page,
            @ApiParam(value = "Registros a recuperar", defaultValue = Constant.ALL_ITEMS) @RequestParam(value = "pageSize", defaultValue = Constant.ALL_ITEMS, required = false) String pageSize,
            @ApiParam(value = "Estatus de los registros a recuperar", defaultValue = Constant.DEFAULT_ESTATUS) @RequestParam(value = "status", defaultValue = Constant.DEFAULT_ESTATUS, required = false) String status,
            @ApiParam(value = "Licenciatura de los registros a recuperar", defaultValue = Constant.LICENCIATURA_DEFAULT) @RequestParam(value = "licenciatura", defaultValue = Constant.LICENCIATURA_DEFAULT, required = false) String licenciatura
    ) {
        if (pageSize.equalsIgnoreCase(Constant.ALL_ITEMS)) {
            pageSize = Constant.ITEMS_FOR_PAGE;
        }
        return grupoService.getAllByStatusAndOneParam(Integer.parseInt(page), Integer.parseInt(pageSize), status, licenciatura);
    }

}
