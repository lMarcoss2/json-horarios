package edu.calc.becas.mcatalogos.actividades.service;

import edu.calc.becas.common.model.WrapperData;
import edu.calc.becas.mcatalogos.actividades.model.ActividadVo;

public interface ActividadesService {

    WrapperData getAll(int page, int pageSize);
    ActividadVo add(ActividadVo actividad);
}
