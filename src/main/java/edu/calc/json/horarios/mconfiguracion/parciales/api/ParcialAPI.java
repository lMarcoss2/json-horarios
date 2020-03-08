package edu.calc.json.horarios.mconfiguracion.parciales.api;

import edu.calc.json.horarios.common.model.WrapperData;
import edu.calc.json.horarios.mconfiguracion.cicloescolar.model.CicloEscolarVo;
import edu.calc.json.horarios.mconfiguracion.cicloescolar.service.CicloEscolarService;
import edu.calc.json.horarios.mconfiguracion.parciales.model.Parcial;
import edu.calc.json.horarios.mconfiguracion.parciales.service.ParcialService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author Marcos Santiago Leonardo
 * Universidad de la Sierra Sur (UNSIS)
 * Description:
 * Date: 4/9/19
 */
@RestController
@RequestMapping("/parciales")
@Api(description = "Servicios para administración de parciales")
public class ParcialAPI {

    private final ParcialService parcialService;
    private final CicloEscolarService cicloEscolarService;

    @Autowired
    public ParcialAPI(ParcialService parcialService, CicloEscolarService cicloEscolarService) {
        this.parcialService = parcialService;
        this.cicloEscolarService = cicloEscolarService;
    }

    @GetMapping()
    @ApiOperation("Obtiene el listado de parciales del periodo actual")
    public WrapperData<Parcial> getAll() {
        WrapperData<CicloEscolarVo> cicloEscolar = cicloEscolarService.getAllByStatus(0, 0, null);
        String cvePeriodo = cicloEscolar.getData().get(0).getClave();

        WrapperData<Parcial> parcialWrapperData = new WrapperData<>();
        parcialWrapperData.setData(this.parcialService.getAllByPeriodo(cvePeriodo));
        parcialWrapperData.setPage(0);
        parcialWrapperData.setPageSize(parcialWrapperData.getData().size());
        parcialWrapperData.setLengthData(parcialWrapperData.getData().size());
        return parcialWrapperData;
    }

    @PatchMapping
    @ApiOperation("Actualiza datos del parcial")
    public Parcial update(@RequestBody Parcial parcial) {
        return this.parcialService.update(parcial);
    }

    @PostMapping
    @ApiOperation("Registra un nuevo parcial")
    public Parcial add(@RequestBody Parcial parcial) throws Exception {

        parcial.setAgregadoPor("admin");
        CicloEscolarVo cicloEscolarVo = cicloEscolarService.getParcialActual();
        parcial.setCvePeriodo(cicloEscolarVo.getClave());
        parcial.setDescPeriodo(cicloEscolarVo.getNombre());
        return this.parcialService.add(parcial);
    }


}
