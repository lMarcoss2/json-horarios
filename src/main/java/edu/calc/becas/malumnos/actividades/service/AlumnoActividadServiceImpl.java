package edu.calc.becas.malumnos.actividades.service;

import edu.calc.becas.malumnos.actividades.dao.AlumnoActividadDao;
import edu.calc.becas.mcatalogos.actividades.model.ActividadVo;
import org.springframework.stereotype.Service;

/**
 * @author Marcos Santiago Leonardo
 * Universidad de la Sierra Sur (UNSIS)
 * Description: servicios para consulta de actividades por alumnos
 * Date: 2019-06-16
 */
@Service
public class AlumnoActividadServiceImpl implements AlumnoActividadService {

    private final AlumnoActividadDao alumnoActividadDao;

    public AlumnoActividadServiceImpl(AlumnoActividadDao alumnoActividadDao) {
        this.alumnoActividadDao = alumnoActividadDao;
    }

    @Override
    public ActividadVo getActividadByAlumno(String matricula) {
        return alumnoActividadDao.getActividadByAlumno(matricula);
    }
}
