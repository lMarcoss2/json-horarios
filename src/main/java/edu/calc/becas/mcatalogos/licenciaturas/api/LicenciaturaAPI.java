package edu.calc.becas.mcatalogos.licenciaturas.api;

import edu.calc.becas.common.model.WrapperData;
import edu.calc.becas.mcatalogos.licenciaturas.model.Licenciatura;
import edu.calc.becas.mcatalogos.licenciaturas.service.LicenciaturaService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import static edu.calc.becas.common.utils.Constant.*;

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
            @ApiParam(value = "Página a recuperar", defaultValue = "0") @RequestParam(value = "page", defaultValue = DEFAULT_PAGE, required = false) String page,
            @ApiParam(value = "Registros a recuperar", defaultValue = "-1") @RequestParam(value = "pageSize", defaultValue = ITEMS_FOR_PAGE, required = false) String pageSize,
            @ApiParam(value = "Estatus de los registros a recuperar", defaultValue = "All") @RequestParam(value = "status", defaultValue = ESTATUS_DEFAULT, required = false) String status
    ) {
        return licenciaturaService.getAll(Integer.parseInt(page), Integer.parseInt(pageSize), status);
    }

    @PostMapping
    @ApiOperation(value = "Registra una licenciatura")
    public Licenciatura add(@ApiParam(value = "Licenciatura a registrar", required = true) @RequestBody Licenciatura licenciatura) {
        licenciatura.setAgregadoPor("Admin");
        return licenciaturaService.add(licenciatura);
    }

    @PutMapping
    @ApiOperation(value = "Actualiza datos de una licenciatura")
    public Licenciatura update(@ApiParam(value = "Licenciatura a actualizar", required = true) @RequestBody Licenciatura licenciatura) {
        licenciatura.setActualizadoPor("Admin");
        return licenciaturaService.update(licenciatura);
    }
}

