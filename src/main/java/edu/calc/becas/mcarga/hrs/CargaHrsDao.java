package edu.calc.becas.mcarga.hrs;

import edu.calc.becas.malumnos.model.Alumno;

import java.util.List;

/**
 * @author Marcos Santiago Leonardo
 * Universidad de la Sierra Sur (UNSIS)
 * Description:
 * Date: 6/3/19
 */
public interface CargaHrsDao {
    void persistenceHours(List<Alumno> alumnos, int parcial);
}
