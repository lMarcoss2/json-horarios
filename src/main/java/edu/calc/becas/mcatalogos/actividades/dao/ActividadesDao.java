package edu.calc.becas.mcatalogos.actividades.dao;

import edu.calc.becas.common.model.WrapperData;
import edu.calc.becas.mcatalogos.actividades.model.ActividadVo;

public interface ActividadesDao {
  WrapperData getAll(int page, int pageSize);
  ActividadVo add(ActividadVo actividad);
}
