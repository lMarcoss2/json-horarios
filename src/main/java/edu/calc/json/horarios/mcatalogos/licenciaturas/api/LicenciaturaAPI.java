package edu.calc.json.horarios.mcatalogos.licenciaturas.api;

import edu.calc.json.horarios.mcatalogos.licenciaturas.model.Licenciatura;
import edu.calc.json.horarios.mcatalogos.licenciaturas.service.LicenciaturaService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Marcos Santiago Leonardo
 * Meltsan Solutions
 * Description: implements services licenciaturas
 * Date: 3/23/19
 */

@RestController
@RequestMapping("/carreras")
@Api(description = "Servicios para administración de licienciaturas")
public class LicenciaturaAPI {

    private final LicenciaturaService licenciaturaService;

    @Autowired
    public LicenciaturaAPI(LicenciaturaService licenciaturaService) {
        this.licenciaturaService = licenciaturaService;
    }

    @GetMapping("/vigentes")
    @ApiOperation(value = "Obtiene el listado de licenciaturas")
    public List<Licenciatura> getAll() throws Exception {
        return licenciaturaService.getAllVigentes();
    }


    @GetMapping("/detalle-carrera")
    @ApiOperation(value = "detalle carrera por clave")
    public Licenciatura getDetalleCarrera(@RequestParam(value = "clave") String clave) throws Exception {
        return this.licenciaturaService.getDetalleCarrera(clave);
    }
}

