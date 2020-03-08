package edu.calc.json.horarios.mcatalogos.actividades.service;

import edu.calc.json.horarios.common.model.LabelValueData;
import edu.calc.json.horarios.common.model.WrapperData;
import edu.calc.json.horarios.common.service.CrudGenericService;
import edu.calc.json.horarios.mcatalogos.actividades.model.ActividadVo;
import edu.calc.json.horarios.mcatalogos.actividades.model.DetalleActividadVo;

import java.util.List;

public interface ActividadesService extends CrudGenericService<ActividadVo> {

    WrapperData getAllDetalle(int page, int pageSize, String idActividad, String ciclo, String status, String username);

    List<LabelValueData> getActividades();

    ActividadVo update(ActividadVo detalle);

    DetalleActividadVo add(DetalleActividadVo detalle);

    DetalleActividadVo udateDetail(DetalleActividadVo detalle);
}
