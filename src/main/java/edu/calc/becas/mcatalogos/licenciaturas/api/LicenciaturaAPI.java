package edu.calc.becas.mcatalogos.licenciaturas.api;

import edu.calc.becas.common.model.WrapperData;
import edu.calc.becas.mcatalogos.licenciaturas.model.Licenciatura;
import edu.calc.becas.mcatalogos.licenciaturas.service.LicenciaturaService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
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
            @RequestParam(value = "page", defaultValue = DEFAULT_PAGE, required = false) String page,
            @RequestParam(value = "pageSize", defaultValue = ITEMS_FOR_PAGE, required = false) String pageSize,
            @RequestParam(value = "status", defaultValue = ESTATUS_DEFAULT, required = false) String status
    ) {
        return licenciaturaService.getAll(Integer.parseInt(page), Integer.parseInt(pageSize), status);
    }

    @PostMapping
    @ApiOperation(value = "Registra una licenciaturas")
    public Licenciatura add(@RequestBody Licenciatura lic) {
        lic.setAgregadoPor("Admin");
        return licenciaturaService.add(lic);
    }

    @PutMapping
    @ApiOperation(value = "Actualiza datos de una licenciaturas")
    public Licenciatura update(@RequestBody Licenciatura lic) {
        lic.setActualizadoPor("Admin");
        return licenciaturaService.update(lic);
    }
}

