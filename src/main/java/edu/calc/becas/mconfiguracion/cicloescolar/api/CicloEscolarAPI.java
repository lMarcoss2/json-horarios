package edu.calc.becas.mconfiguracion.cicloescolar.api;

import edu.calc.becas.common.model.LabelValueData;
import edu.calc.becas.common.model.WrapperData;
import edu.calc.becas.mconfiguracion.cicloescolar.model.CicloEscolarVo;
import edu.calc.becas.mconfiguracion.cicloescolar.service.CicloEscolarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static edu.calc.becas.common.utils.Constant.DEFAULT_PAGE;
import static edu.calc.becas.common.utils.Constant.ITEMS_FOR_PAGE;

@RestController
@RequestMapping("/cicloescolar")
public class CicloEscolarAPI {

    private CicloEscolarService cicloEscolarService;

    @Autowired
    public CicloEscolarAPI (CicloEscolarService cicloEscolarService){this.cicloEscolarService=cicloEscolarService;}


    @GetMapping
    public WrapperData getAll(
        @RequestParam(value = "page", defaultValue = DEFAULT_PAGE, required = false) String page,
        @RequestParam(value = "pageSize", defaultValue = ITEMS_FOR_PAGE, required = false) String pageSize
    ){
        return cicloEscolarService.getAll(Integer.parseInt(page), Integer.parseInt(pageSize));
    }

    @PostMapping
    public CicloEscolarVo add(@RequestBody CicloEscolarVo ciclo){
        System.out.println("ciclo : > " + ciclo);
            cicloEscolarService.add(ciclo);
        return ciclo;
    }

    @GetMapping("/ciclos")
    public List<LabelValueData> getListCiclos(@RequestBody CicloEscolarVo ciclo){
        System.out.println("ciclo : > " + ciclo);
        return cicloEscolarService.getListCatalog();
    }

}
