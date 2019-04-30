package edu.calc.becas.mcatalogos.actividades.dao;

import edu.calc.becas.common.model.WrapperData;
import edu.calc.becas.mcatalogos.actividades.model.ActividadesVo;

public interface ActividadesDao {
  WrapperData getAll(int page, int pageSize);
  ActividadesVo add(ActividadesVo actividad);
}
