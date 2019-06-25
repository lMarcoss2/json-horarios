package edu.calc.becas.mconfiguracion.cicloescolar.service;

import edu.calc.becas.common.model.LabelValueData;
import edu.calc.becas.common.service.CrudGenericService;
import edu.calc.becas.mconfiguracion.cicloescolar.model.CicloEscolarVo;

import java.util.List;

public interface CicloEscolarService extends CrudGenericService<CicloEscolarVo> {
    List<LabelValueData> getListCatalog();
}
