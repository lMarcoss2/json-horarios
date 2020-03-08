package edu.calc.json.horarios.mcatalogos.licenciaturas.api;

import edu.calc.json.horarios.common.model.WrapperData;
import edu.calc.json.horarios.mcatalogos.licenciaturas.service.LicenciaturaService;
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
 * Meltsan Solutions
 * Description: implements services licenciaturas
 * Date: 3/23/19
 */

@RestController
@RequestMapping("/licenciaturas")
@Api(description = "Servicios para administración de licienciaturas")
public class LicenciaturaAPI {

    private final LicenciaturaService licenciaturaService;

    @Autowired
    public LicenciaturaAPI(LicenciaturaService licenciaturaService) {
        this.licenciaturaService = licenciaturaService;
    }

    @GetMapping
    @ApiOperation(value = "Obtiene el listado de licenciaturas")
    public WrapperData getAll(
            @ApiParam(value = "Página a recuperar", defaultValue = Constant.DEFAULT_PAGE) @RequestParam(value = "page", defaultValue = Constant.DEFAULT_PAGE, required = false) String page,
            @ApiParam(value = "Registros a recuperar", defaultValue = Constant.ALL_ITEMS) @RequestParam(value = "pageSize", defaultValue = Constant.ALL_ITEMS, required = false) String pageSize,
            @ApiParam(value = "Estatus de los registros a recuperar", defaultValue = Constant.DEFAULT_ESTATUS) @RequestParam(value = "status", defaultValue = Constant.DEFAULT_ESTATUS, required = false) String status
    ) {
        if (pageSize.equalsIgnoreCase(Constant.ALL_ITEMS)) {
            pageSize = Constant.ITEMS_FOR_PAGE;
        }

        return licenciaturaService.getAllByStatus(Integer.parseInt(page), Integer.parseInt(pageSize), status);
    }

}

