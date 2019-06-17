package edu.calc.becas.malumnos.actividades.service;

import edu.calc.becas.mcatalogos.actividades.model.ActividadVo;

/**
 * @author Marcos Santiago Leonardo
 * Universidad de la Sierra Sur (UNSIS)
 * Description:
 * Date: 2019-06-16
 */
public interface AlumnoActividadService {
    ActividadVo getActividadByAlumno(String matricula);

}
