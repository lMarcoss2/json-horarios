package edu.calc.becas.malumnos.dao;

import edu.calc.becas.common.model.WrapperData;

public interface AlumnosDao {

    WrapperData getAll(int page, int pageSize, String status, String idActividad);

}
