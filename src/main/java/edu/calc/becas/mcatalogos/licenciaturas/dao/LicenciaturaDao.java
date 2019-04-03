package edu.calc.becas.mcatalogos.licenciaturas.dao;

import edu.calc.becas.mcatalogos.licenciaturas.model.Licenciatura;
import edu.calc.becas.common.model.WrapperData;

/**
 * @author Marcos Santiago Leonardo
 * Universidad de la Sierra Sur (UNSIS)
 * Description: define dao for the major service
 * Date: 3/23/19
 */
public interface LicenciaturaDao {
    WrapperData getAll(int page, int pageSize, String status);

    Licenciatura add(Licenciatura lic);

    Licenciatura update(Licenciatura lic);
}
