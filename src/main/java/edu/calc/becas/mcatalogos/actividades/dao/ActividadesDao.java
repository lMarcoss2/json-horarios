package edu.calc.becas.mcatalogos.actividades.dao;

import edu.calc.becas.common.model.LabelValueData;
import edu.calc.becas.common.model.WrapperData;
import edu.calc.becas.mcatalogos.actividades.model.ActividadVo;

import java.util.List;

public interface ActividadesDao {
  WrapperData getAll(int page, int pageSize,String stSatus);
  ActividadVo add(ActividadVo actividad);
  WrapperData getAllDetalle(int page, int pageSize, String idActividad, String ciclo);
  List<LabelValueData> getActividades();
}
