package edu.calc.json.horarios.mcatalogos.grupos.api;

import edu.calc.json.horarios.mcatalogos.grupos.model.Grupo;
import edu.calc.json.horarios.mcatalogos.grupos.service.GrupoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

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
    @ApiOperation(value = "Obtiene el listado de grupos de un periodo")
    public List<Grupo> getAll(@RequestParam(value = "periodo") String periodo) throws IOException {

        return grupoService.getAllByPeriodo(periodo);
    }

}
