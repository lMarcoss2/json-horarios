package edu.calc.becas.malumnos.service;

import edu.calc.becas.common.model.WrapperData;

public interface AlumnosService {

    WrapperData getAll(int page, int pageSize, String status, String idActividad);
}
