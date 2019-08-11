package edu.calc.becas.mconfiguracion.cicloescolar.api;

import edu.calc.becas.common.model.WrapperData;
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
            @RequestParam(value = "page", defaultValue = DEFAULT_PAGE, required = false) String page,
            @RequestParam(value = "pageSize", defaultValue = ITEMS_FOR_PAGE, required = false) String pageSize
    ) {
        return cicloEscolarService.getAllByStatus(Integer.parseInt(page), Integer.parseInt(pageSize), DEFAULT_ESTATUS);
    }


}
