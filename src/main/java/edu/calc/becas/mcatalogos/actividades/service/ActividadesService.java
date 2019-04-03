package edu.calc.becas.mcatalogos.actividades.service;

import edu.calc.becas.common.model.WrapperData;

public interface ActividadesService {

    WrapperData getAll(int page, int pageSize);
}
