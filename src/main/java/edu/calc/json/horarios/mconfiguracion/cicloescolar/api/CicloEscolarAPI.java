package edu.calc.json.horarios.mconfiguracion.cicloescolar.api;

import edu.calc.json.horarios.common.model.WrapperData;
import edu.calc.json.horarios.exceptions.GenericException;
import edu.calc.json.horarios.mconfiguracion.cicloescolar.model.CicloEscolarVo;
import edu.calc.json.horarios.mconfiguracion.cicloescolar.service.CicloEscolarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cicloescolar")
public class CicloEscolarAPI {

    private CicloEscolarService cicloEscolarService;

    @Autowired
    public CicloEscolarAPI(CicloEscolarService cicloEscolarService) {
        this.cicloEscolarService = cicloEscolarService;
    }


    @GetMapping
    public WrapperData getAll(
    ) {
        return cicloEscolarService.getAllByStatus(0, 0, null);
    }

    @GetMapping("/actual")
    public CicloEscolarVo getCicloEscolarActual() throws GenericException {
        return cicloEscolarService.getCicloEscolarActual();
    }


}
