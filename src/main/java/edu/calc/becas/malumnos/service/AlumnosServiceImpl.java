package edu.calc.becas.malumnos.service;

import edu.calc.becas.common.model.WrapperData;
import edu.calc.becas.malumnos.dao.AlumnosDao;
import edu.calc.becas.malumnos.model.Alumno;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author vampiro
 */
@Service
public class AlumnosServiceImpl implements AlumnosService {

    private final AlumnosDao alumnosDao;

    @Autowired
    public AlumnosServiceImpl(AlumnosDao alumnosDao) {
        this.alumnosDao = alumnosDao;
    }


    @Override
    public WrapperData getAll(int page, int pageSize, String status, String idActividad) {
        return alumnosDao.getAll(page, pageSize, status, idActividad);
    }

    @Override
    public Alumno getByMatricula(String matricula) {
        return alumnosDao.getByMatricula(matricula);
    }
}
