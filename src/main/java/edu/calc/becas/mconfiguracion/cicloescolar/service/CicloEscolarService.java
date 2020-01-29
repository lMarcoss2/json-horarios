package edu.calc.becas.mconfiguracion.cicloescolar.service;

import edu.calc.becas.common.service.CrudGenericService;
import edu.calc.becas.exceptions.GenericException;
import edu.calc.becas.mconfiguracion.cicloescolar.model.CicloEscolarVo;

public interface CicloEscolarService extends CrudGenericService<CicloEscolarVo> {
    CicloEscolarVo getParcialActual() throws Exception;

    CicloEscolarVo getCicloEscolarActual() throws GenericException;
}
