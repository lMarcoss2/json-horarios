package edu.calc.json.horarios.mcarga.hrs;

import edu.calc.json.horarios.malumnos.model.Alumno;
import edu.calc.json.horarios.mconfiguracion.cicloescolar.model.CicloEscolarVo;
import edu.calc.json.horarios.mconfiguracion.parciales.model.Parcial;

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
