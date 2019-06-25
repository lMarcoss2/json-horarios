package edu.calc.becas.mconfiguracion.cicloescolar.dao;

import edu.calc.becas.common.base.dao.CrudGenericDao;
import edu.calc.becas.common.model.LabelValueData;
import edu.calc.becas.mconfiguracion.cicloescolar.model.CicloEscolarVo;

import java.util.List;

public interface CicloEscolarDao extends CrudGenericDao<CicloEscolarVo> {
    List<LabelValueData> getListCatalog();
}
