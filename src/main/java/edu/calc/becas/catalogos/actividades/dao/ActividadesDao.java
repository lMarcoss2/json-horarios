package edu.calc.becas.catalogos.actividades.dao;

import edu.calc.becas.common.model.WrapperData;

public interface ActividadesDao {
  WrapperData getAll(int page, int pageSize);
}
