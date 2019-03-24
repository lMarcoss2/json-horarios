package edu.calc.becas.catalogos.licenciaturas.api;

import edu.calc.becas.catalogos.licenciaturas.model.Licenciatura;
import edu.calc.becas.catalogos.licenciaturas.service.LicenciaturaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
    public List<Licenciatura> getAll() {
        return licenciaturaService.getAll();
    }
}
