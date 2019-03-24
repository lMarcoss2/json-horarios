package edu.calc.becas.catalogos.licenciaturas.dao;

import edu.calc.becas.catalogos.licenciaturas.model.Licenciatura;

import java.util.List;

/**
 * @author Marcos Santiago Leonardo
 * Universidad de la Sierra Sur (UNSIS)
 * Description: define dao for the major service
 * Date: 3/23/19
 */
public interface LicenciaturaDao {
    List<Licenciatura> getAll();
}
