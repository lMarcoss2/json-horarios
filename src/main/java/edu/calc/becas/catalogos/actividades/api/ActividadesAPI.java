package edu.calc.becas.catalogos.actividades.api;

import edu.calc.becas.catalogos.actividades.service.ActividadesService;
import edu.calc.becas.common.model.WrapperData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import static edu.calc.becas.common.utils.Constant.DEFAULT_PAGE;
import static edu.calc.becas.common.utils.Constant.ITEMS_FOR_PAGE;

@RestController
@RequestMapping("/actividades")
public class ActividadesAPI {
    private final ActividadesService actividadesService;

    @Autowired
    public ActividadesAPI(ActividadesService actividadesService){this.actividadesService = actividadesService;}

    @GetMapping
    public WrapperData getAll(
            @RequestParam(value = "page", defaultValue =  DEFAULT_PAGE, required = false) String page,
            @RequestParam(value = "pageSize", defaultValue = ITEMS_FOR_PAGE, required=false) String pageSize){
        return actividadesService.getAll(Integer.parseInt(page), Integer.parseInt(pageSize));
    }

}
