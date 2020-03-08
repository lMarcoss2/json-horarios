package edu.calc.json.horarios.mconfiguracion.parciales.dao;

import edu.calc.json.horarios.common.base.dao.CrudGenericDao;
import edu.calc.json.horarios.mconfiguracion.parciales.model.Parcial;

import java.util.List;

/**
 * @author Marcos Santiago Leonardo
 * Universidad de la Sierra Sur (UNSIS)
 * Description:
 * Date: 4/9/19
 */
public interface ParcialDao extends CrudGenericDao<Parcial> {
    List<Parcial> getAllByPeriodo(String cvePeriodo);

    Parcial getParcialActual();
}
