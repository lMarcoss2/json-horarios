package edu.calc.json.horarios.mconfiguracion.cicloescolar.service;

import edu.calc.json.horarios.common.service.CrudGenericService;
import edu.calc.json.horarios.exceptions.GenericException;
import edu.calc.json.horarios.mconfiguracion.cicloescolar.model.CicloEscolarVo;

public interface CicloEscolarService extends CrudGenericService<CicloEscolarVo> {
    CicloEscolarVo getParcialActual() throws Exception;

    CicloEscolarVo getCicloEscolarActual() throws GenericException;
}
