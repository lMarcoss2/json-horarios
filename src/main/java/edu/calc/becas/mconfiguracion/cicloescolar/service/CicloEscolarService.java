package edu.calc.becas.mconfiguracion.cicloescolar.service;

import edu.calc.becas.common.model.WrapperData;
import edu.calc.becas.mconfiguracion.cicloescolar.model.CicloEscolarVo;

public interface CicloEscolarService {
    WrapperData getAll(int page, int pageSize);

    CicloEscolarVo add(CicloEscolarVo ciclo);
}
