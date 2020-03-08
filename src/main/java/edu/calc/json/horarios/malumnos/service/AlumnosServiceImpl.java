package edu.calc.json.horarios.malumnos.service;

import edu.calc.json.horarios.common.model.WrapperData;
import edu.calc.json.horarios.malumnos.dao.AlumnosDao;
import edu.calc.json.horarios.malumnos.model.Alumno;
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
    public WrapperData getAllByStatus(int page, int pageSize, String status) {
        return null;
    }

    @Override
    public WrapperData getAllByStatusAndOneParam(int page, int pageSize, String status, String idActividad) {
        return alumnosDao.getAllByStatusAndOneParam(page, pageSize, status, idActividad);
    }

    @Override
    public Alumno add(Alumno alumno) {
        return alumnosDao.add(alumno);
    }

    @Override
    public Alumno update(Alumno alumno) {
        return null;
    }

}
