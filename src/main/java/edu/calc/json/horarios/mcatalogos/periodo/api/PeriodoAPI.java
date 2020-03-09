package edu.calc.json.horarios.mcatalogos.periodo.api;

import edu.calc.json.horarios.exceptions.GenericException;
import edu.calc.json.horarios.mcatalogos.periodo.model.Periodo;
import edu.calc.json.horarios.mcatalogos.periodo.service.PeriodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/periodo")
public class PeriodoAPI {

    private PeriodoService periodoService;

    @Autowired
    public PeriodoAPI(PeriodoService periodoService) {
        this.periodoService = periodoService;
    }

    @GetMapping("/actual")
    public Periodo getCicloEscolarActual() throws GenericException {
        return periodoService.getCicloEscolarActual();
    }


}
