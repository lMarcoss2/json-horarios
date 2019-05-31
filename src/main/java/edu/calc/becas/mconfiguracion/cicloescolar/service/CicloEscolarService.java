package edu.calc.becas.mconfiguracion.cicloescolar.service;

import edu.calc.becas.common.model.LabelValueData;
import edu.calc.becas.common.model.WrapperData;
import edu.calc.becas.mconfiguracion.cicloescolar.model.CicloEscolarVo;

import java.util.List;

public interface CicloEscolarService {
    WrapperData getAll(int page, int pageSize);

    CicloEscolarVo add(CicloEscolarVo ciclo);

    List<LabelValueData> getListCatalog();
}
