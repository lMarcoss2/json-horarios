package edu.calc.json.horarios.malumnos.actividades.dao;

import edu.calc.json.horarios.common.model.WrapperData;
import edu.calc.json.horarios.mcatalogos.actividades.model.ActividadVo;
import edu.calc.json.horarios.mconfiguracion.cicloescolar.model.CicloEscolarVo;

/**
 * @author Marcos Santiago Leonardo
 * Universidad de la Sierra Sur (UNSIS)
 * Description: definicion de servicios para consulta de actividades por alumno(s)
 * Date: 2019-06-16
 */
public interface AlumnoActividadDao {
    ActividadVo getActividadByAlumno(String matricula, CicloEscolarVo cicloEscolarActual);
  WrapperData getAllAlumnosByActividad(int page, int pageSize, String idActividad, String idCiclo);
}
