package edu.calc.becas.mconfiguracion.parciales.dao;

import edu.calc.becas.mconfiguracion.parciales.model.Parcial;

import java.util.List;

/**
 * @author Marcos Santiago Leonardo
 * Universidad de la Sierra Sur (UNSIS)
 * Description:
 * Date: 4/9/19
 */
public interface ParcialDao {
    List<Parcial> getAll();

    Parcial update(Parcial parcial);
}
