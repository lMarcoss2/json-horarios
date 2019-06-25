package edu.calc.becas.mcatalogos.actividades.dao;

import edu.calc.becas.common.base.dao.CrudGenericDao;
import edu.calc.becas.common.model.LabelValueData;
import edu.calc.becas.common.model.WrapperData;
import edu.calc.becas.mcatalogos.actividades.model.ActividadVo;
import edu.calc.becas.mcatalogos.actividades.model.DetalleActividadVo;

import java.util.List;

public interface ActividadesDao extends CrudGenericDao<ActividadVo> {
    WrapperData getAllDetalle(int page, int pageSize, String idActividad, String ciclo);

    List<LabelValueData> getActividades();

    DetalleActividadVo add(DetalleActividadVo detalle);

    DetalleActividadVo udateDetail(DetalleActividadVo detalle);
}

