package edu.calc.becas.malumnos.dao;

import edu.calc.becas.common.model.WrapperData;
import edu.calc.becas.malumnos.model.Alumno;

public interface AlumnosDao {

    WrapperData getAll(int page, int pageSize, String status, String idActividad);

    Alumno getByMatricula(String matricula);

}
