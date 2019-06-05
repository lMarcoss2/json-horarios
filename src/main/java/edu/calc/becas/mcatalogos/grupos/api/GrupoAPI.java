package edu.calc.becas.mcatalogos.grupos.api;

import edu.calc.becas.common.model.WrapperData;
import edu.calc.becas.mcatalogos.grupos.model.Grupo;
import edu.calc.becas.mcatalogos.grupos.service.GrupoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import static edu.calc.becas.common.utils.Constant.*;

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
            @ApiParam(value = "Página a recuperar", defaultValue = "0") @RequestParam(value = "page", defaultValue = DEFAULT_PAGE, required = false) String page,
            @ApiParam(value = "Registros a recuperar", defaultValue = "-1") @RequestParam(value = "pageSize", defaultValue = ITEMS_FOR_PAGE, required = false) String pageSize,
            @ApiParam(value = "Estatus de los registros a recuperar", defaultValue = "All") @RequestParam(value = "status", defaultValue = ESTATUS_DEFAULT, required = false) String status,
            @ApiParam(value = "Estatus de los registros a recuperar", defaultValue = "All") @RequestParam(value = "licenciatura", defaultValue = LICENCIATURA_DEFAULT, required = false) String licenciatura
    ) {
        return grupoService.getAll(Integer.parseInt(page), Integer.parseInt(pageSize), status, licenciatura);
    }

    @PostMapping
    @ApiOperation(value = "Registra un grupo")
    public Grupo add(@ApiParam(value = "Grupo a registrar", defaultValue = "0") @RequestBody Grupo grupo) {
        grupo.setAgregadoPor("Admin");
        return grupoService.add(grupo);
    }

    @PutMapping
    @ApiOperation(value = "Actualiza datos de un grupo")
    public Grupo update(@ApiParam(value = "Grupo a actualizar", defaultValue = "0") @RequestBody Grupo grupo) {
        grupo.setActualizadoPor("Admin");
        return grupoService.update(grupo);
    }
}
