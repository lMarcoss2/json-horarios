package edu.calc.becas.mconfiguracion.parciales.api;

import edu.calc.becas.mconfiguracion.parciales.model.Parcial;
import edu.calc.becas.mconfiguracion.parciales.service.ParcialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Marcos Santiago Leonardo
 * Universidad de la Sierra Sur (UNSIS)
 * Description:
 * Date: 4/9/19
 */
@RestController
@RequestMapping("/parciales")
public class ParcialAPI {

    private final ParcialService parcialService;

    @Autowired
    public ParcialAPI(ParcialService parcialService) {
        this.parcialService = parcialService;
    }

    @GetMapping
    public List<Parcial> getAll() {
        return this.parcialService.getAll();
    }

    @PatchMapping
    public Parcial update(@RequestBody Parcial parcial) {
        return this.parcialService.update(parcial);
    }
}
