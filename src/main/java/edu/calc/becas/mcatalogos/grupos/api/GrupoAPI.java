package edu.calc.becas.mcatalogos.grupos.api;

import edu.calc.becas.common.model.WrapperData;
import edu.calc.becas.mcatalogos.grupos.model.Grupo;
import edu.calc.becas.mcatalogos.grupos.service.GrupoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import static edu.calc.becas.common.utils.Constant.DEFAULT_PAGE;
import static edu.calc.becas.common.utils.Constant.ITEMS_FOR_PAGE;

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
            @RequestParam(value = "page", defaultValue = DEFAULT_PAGE, required = false) String page,
            @RequestParam(value = "pageSize", defaultValue = ITEMS_FOR_PAGE, required = false) String pageSize) {
        return grupoService.getAll(Integer.parseInt(page), Integer.parseInt(pageSize));
    }

    @PostMapping
    @ApiOperation(value = "Registra un grupo")
    public Grupo add(@RequestBody Grupo grupo) {
        grupo.setAgregadoPor("Admin");
        return grupoService.add(grupo);
    }

    @PutMapping
    @ApiOperation(value = "Actualiza datos de un grupo")
    public Grupo update(@RequestBody Grupo grupo) {
        grupo.setActualizadoPor("Admin");
        return grupoService.update(grupo);
    }
}
