package edu.calc.becas.catalogos.licenciaturas.service;

import edu.calc.becas.common.model.WrapperData;

/**
 * @author Marcos Santiago Leonardo
 * Universidad de la Sierra Sur (UNSIS)
 * Description: Services definition for majors
 * Date: 3/23/19
 */
public interface LicenciaturaService {
    WrapperData getAll(int page, int pageSize);
}
