package edu.calc.becas.mcatalogos.actividades.api;

import edu.calc.becas.mcatalogos.actividades.model.ActividadVo;
import edu.calc.becas.mcatalogos.actividades.service.ActividadesService;
import edu.calc.becas.common.model.WrapperData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping
    public ActividadVo add(@RequestBody ActividadVo actividad){
        actividad.setActualizadoPor("Admin");
        return actividadesService.add(actividad);
    }
}
