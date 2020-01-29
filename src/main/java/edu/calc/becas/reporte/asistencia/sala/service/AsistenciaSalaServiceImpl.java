package edu.calc.becas.reporte.asistencia.sala.service;

import edu.calc.becas.reporte.asistencia.sala.dao.AsistenciaSalaDao;
import edu.calc.becas.reporte.asistencia.sala.model.AlumnoAsistenciaSala;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AsistenciaSalaServiceImpl implements AsistenciaSalaService {

    private final AsistenciaSalaDao asistenciaSalaDao;

    public AsistenciaSalaServiceImpl(AsistenciaSalaDao asistenciaSalaDao) {
        this.asistenciaSalaDao = asistenciaSalaDao;
    }

    @Override
    public List<AlumnoAsistenciaSala> getAlumnosByScheduleAndUser(String username, String idHorario) {
        return asistenciaSalaDao.getAlumnosByScheduleAndUser(username, idHorario);
    }
}