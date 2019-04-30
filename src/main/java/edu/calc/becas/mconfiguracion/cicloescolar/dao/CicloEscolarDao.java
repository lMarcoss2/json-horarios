package edu.calc.becas.mconfiguracion.cicloescolar.dao;

import edu.calc.becas.common.model.WrapperData;
import edu.calc.becas.mconfiguracion.cicloescolar.model.CicloEscolarVo;

public interface CicloEscolarDao {
    WrapperData getAll(int page, int pageSize);

    CicloEscolarVo add(CicloEscolarVo ciclo);
}
