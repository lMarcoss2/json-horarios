package edu.calc.json.horarios.malumnos.actividades.service;

import edu.calc.json.horarios.common.model.WrapperData;
import edu.calc.json.horarios.malumnos.actividades.dao.AlumnoActividadDao;
import edu.calc.json.horarios.mcatalogos.actividades.model.ActividadVo;
import edu.calc.json.horarios.mconfiguracion.cicloescolar.model.CicloEscolarVo;
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
    public ActividadVo getActividadByAlumno(String matricula, CicloEscolarVo cicloEscolarActual) {
        return alumnoActividadDao.getActividadByAlumno(matricula, cicloEscolarActual);
    }

  @Override
  public WrapperData getAllAlumnosByActividad(int page, int pageSize, String idActividad, String idCiclo) {
    return alumnoActividadDao.getAllAlumnosByActividad(page, pageSize, idActividad, idCiclo);
  }


}
