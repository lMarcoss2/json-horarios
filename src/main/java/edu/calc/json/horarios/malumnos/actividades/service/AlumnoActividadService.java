package edu.calc.json.horarios.malumnos.actividades.service;

import edu.calc.json.horarios.common.model.WrapperData;
import edu.calc.json.horarios.mcatalogos.actividades.model.ActividadVo;
import edu.calc.json.horarios.mconfiguracion.cicloescolar.model.CicloEscolarVo;

/**
 * @author Marcos Santiago Leonardo
 * Universidad de la Sierra Sur (UNSIS)
 * Description:
 * Date: 2019-06-16
 */
public interface AlumnoActividadService {
    ActividadVo getActividadByAlumno(String matricula, CicloEscolarVo cicloEscolarActual);
    WrapperData getAllAlumnosByActividad(int page, int pageSize, String idActividad, String idCiclo);

}
