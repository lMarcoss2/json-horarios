package edu.calc.becas.catalogos.actividades.service;

import edu.calc.becas.common.model.WrapperData;

public interface ActividadesService {

    WrapperData getAll(int page, int pageSize);
}
