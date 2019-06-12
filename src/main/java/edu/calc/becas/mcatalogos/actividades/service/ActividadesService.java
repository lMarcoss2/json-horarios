package edu.calc.becas.mcatalogos.actividades.service;

import edu.calc.becas.common.model.LabelValueData;
import edu.calc.becas.common.model.WrapperData;
import edu.calc.becas.mcatalogos.actividades.model.ActividadVo;

import java.util.List;

public interface ActividadesService {

    WrapperData getAll(int page, int pageSize, String status);
    ActividadVo add(ActividadVo actividad);
    WrapperData getAllDetalle(int page, int pageSize, String status, String ciclo);
    List<LabelValueData> getActividades();
}
