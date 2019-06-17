package edu.calc.becas.malumnos.service;

import edu.calc.becas.common.model.WrapperData;
import edu.calc.becas.malumnos.model.Alumno;

public interface AlumnosService {

    WrapperData getAll(int page, int pageSize, String status, String idActividad);

    Alumno getByMatricula(String matricula);
}
