package edu.calc.becas.catalogos.grupos.api;

import edu.calc.becas.catalogos.grupos.model.Grupo;
import edu.calc.becas.catalogos.grupos.service.GrupoService;
import edu.calc.becas.common.model.WrapperData;
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
public class GrupoAPI {

    private final GrupoService grupoService;

    @Autowired
    public GrupoAPI(GrupoService grupoService) {
        this.grupoService = grupoService;
    }

    @GetMapping
    public WrapperData getAll(
            @RequestParam(value = "page", defaultValue = DEFAULT_PAGE, required = false) String page,
            @RequestParam(value = "pageSize", defaultValue = ITEMS_FOR_PAGE, required = false) String pageSize) {
        return grupoService.getAll(Integer.parseInt(page), Integer.parseInt(pageSize));
    }

    @PostMapping
    public Grupo add(@RequestBody Grupo grupo) {
        grupo.setAgregadoPor("Admin");
        return grupoService.add(grupo);
    }

    @PutMapping
    public Grupo update(@RequestBody Grupo grupo) {
        grupo.setActualizadoPor("Admin");
        return grupoService.update(grupo);
    }
}
