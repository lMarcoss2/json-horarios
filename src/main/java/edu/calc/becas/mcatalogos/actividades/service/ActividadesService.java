package edu.calc.becas.mcatalogos.actividades.service;

import edu.calc.becas.common.model.WrapperData;
import edu.calc.becas.mcatalogos.actividades.model.ActividadesVo;

public interface ActividadesService {

    WrapperData getAll(int page, int pageSize);
    ActividadesVo add(ActividadesVo actividad);
}
