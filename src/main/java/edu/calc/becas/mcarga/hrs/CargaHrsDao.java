package edu.calc.becas.mcarga.hrs;

import edu.calc.becas.malumnos.model.Alumno;
import edu.calc.becas.mconfiguracion.cicloescolar.model.CicloEscolarVo;
import edu.calc.becas.mconfiguracion.parciales.model.Parcial;

import java.util.List;

/**
 * @author Marcos Santiago Leonardo
 * Universidad de la Sierra Sur (UNSIS)
 * Description:
 * Date: 6/3/19
 */
public interface CargaHrsDao {
    int persistenceHours(List<Alumno> alumnos, Parcial parcial, CicloEscolarVo cicloEscolarActual);
}
