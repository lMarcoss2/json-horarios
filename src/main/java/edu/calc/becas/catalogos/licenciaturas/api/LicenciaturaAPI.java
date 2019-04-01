package edu.calc.becas.catalogos.licenciaturas.api;

import edu.calc.becas.catalogos.licenciaturas.model.Licenciatura;
import edu.calc.becas.catalogos.licenciaturas.service.LicenciaturaService;
import edu.calc.becas.common.model.WrapperData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import static edu.calc.becas.common.utils.Constant.*;

/**
 * @author Marcos Santiago Leonardo
 * Meltsan Solutions
 * Description: implements services majors
 * Date: 3/23/19
 */
@RestController
@RequestMapping("/licenciaturas")
public class LicenciaturaAPI {

    private final LicenciaturaService licenciaturaService;

    @Autowired
    public LicenciaturaAPI(LicenciaturaService licenciaturaService) {
        this.licenciaturaService = licenciaturaService;
    }

    @GetMapping
    public WrapperData getAll(
            @RequestParam(value = "page", defaultValue = DEFAULT_PAGE, required = false) String page,
            @RequestParam(value = "pageSize", defaultValue = ITEMS_FOR_PAGE, required = false) String pageSize,
            @RequestParam(value = "status", defaultValue = ESTATUS_DEFAULT, required = false) String status
            ) {
        return licenciaturaService.getAll(Integer.parseInt(page), Integer.parseInt(pageSize), status);
    }

    @PostMapping
    public Licenciatura add(@RequestBody Licenciatura lic) {
        lic.setAgregadoPor("Admin");
        return licenciaturaService.add(lic);
    }

    @PutMapping
    public Licenciatura update(@RequestBody Licenciatura lic) {
        lic.setActualizadoPor("Admin");
        return licenciaturaService.update(lic);
    }
}
