package edu.calc.becas.mconfiguracion.cicloescolar.api;

import edu.calc.becas.common.model.WrapperData;
import edu.calc.becas.exceptions.GenericException;
import edu.calc.becas.mconfiguracion.cicloescolar.model.CicloEscolarVo;
import edu.calc.becas.mconfiguracion.cicloescolar.service.CicloEscolarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import static edu.calc.becas.common.utils.Constant.*;

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
