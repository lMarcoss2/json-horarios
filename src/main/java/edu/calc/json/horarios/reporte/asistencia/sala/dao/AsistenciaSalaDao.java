package edu.calc.json.horarios.reporte.asistencia.sala.dao;

import edu.calc.json.horarios.mseguridad.usuarios.model.Usuario;
import edu.calc.json.horarios.reporte.asistencia.sala.model.AlumnoAsistenciaSala;
import edu.calc.json.horarios.reporte.asistencia.sala.model.FechaAsistencia;
import edu.calc.json.horarios.reporte.asistencia.sala.model.PaseAsistencia;

import java.util.List;

public interface AsistenciaSalaDao {
    List<AlumnoAsistenciaSala> getAlumnosByScheduleAndUser(String username, String idHorario, List<FechaAsistencia> fechasAsistencia);

    List<PaseAsistencia> addPresenceByDate(List<PaseAsistencia> asistencias, Usuario usuario);
}
