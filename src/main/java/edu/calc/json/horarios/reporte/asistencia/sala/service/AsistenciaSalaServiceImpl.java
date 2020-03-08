package edu.calc.json.horarios.reporte.asistencia.sala.service;

import edu.calc.json.horarios.mseguridad.usuarios.model.Usuario;
import edu.calc.json.horarios.reporte.asistencia.sala.dao.AsistenciaSalaDao;
import edu.calc.json.horarios.reporte.asistencia.sala.model.AlumnoAsistenciaSala;
import edu.calc.json.horarios.reporte.asistencia.sala.model.FechaAsistencia;
import edu.calc.json.horarios.reporte.asistencia.sala.model.PaseAsistencia;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AsistenciaSalaServiceImpl implements AsistenciaSalaService {

    private final AsistenciaSalaDao asistenciaSalaDao;

    public AsistenciaSalaServiceImpl(AsistenciaSalaDao asistenciaSalaDao) {
        this.asistenciaSalaDao = asistenciaSalaDao;
    }

    @Override
    public List<AlumnoAsistenciaSala> getAlumnosByScheduleAndUser(String username, String idHorario, List<FechaAsistencia> fechasAsistencia) {
        return asistenciaSalaDao.getAlumnosByScheduleAndUser(username, idHorario, fechasAsistencia);
    }

    @Override
    public List<PaseAsistencia> addPresenceByDate(List<PaseAsistencia> asistencias, Usuario usuario) {
        return asistenciaSalaDao.addPresenceByDate(asistencias, usuario);
    }

}
