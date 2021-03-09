package edu.calc.json.horarios.mcatalogos.periodo.api;

import edu.calc.json.horarios.mcatalogos.periodo.model.Periodo;
import edu.calc.json.horarios.mcatalogos.periodo.service.PeriodoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/periodo")
@Api(description = "Servicios para administración periodos")
public class PeriodoAPI {

    private final PeriodoService periodoService;

    @Autowired
    public PeriodoAPI(PeriodoService periodoService) {
        this.periodoService = periodoService;
    }

    @GetMapping("/actual")
    @ApiOperation(value = "Obtiene el periodo actual")
    public Periodo getCicloEscolarActual() throws Exception {
        return periodoService.getCicloEscolarActual();
    }


}
