package edu.calc.json.horarios.mconfiguracion.parciales.service;

import edu.calc.json.horarios.common.service.CrudGenericService;
import edu.calc.json.horarios.mconfiguracion.parciales.model.Parcial;

import java.util.List;

/**
 * @author Marcos Santiago Leonardo
 * Universidad de la Sierra Sur (UNSIS)
 * Description:
 * Date: 4/9/19
 */
public interface ParcialService extends CrudGenericService<Parcial> {

    List<Parcial> getAllByPeriodo(String cvePeriodo);

    Parcial getParcialActual();
}
