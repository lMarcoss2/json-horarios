package edu.calc.becas.mconfiguracion.parciales.service;

import edu.calc.becas.mconfiguracion.parciales.model.Parcial;

import java.util.List;

/**
 * @author Marcos Santiago Leonardo
 * Universidad de la Sierra Sur (UNSIS)
 * Description:
 * Date: 4/9/19
 */
public interface ParcialService {
    List<Parcial> getAll();

    Parcial update(Parcial parcial);

    Parcial getParcialActual();
}
