package edu.calc.becas.reporte.asistencia.sala.dao;

import edu.calc.becas.reporte.asistencia.sala.model.AlumnoAsistenciaSala;

import java.util.List;

public interface AsistenciaSalaDao {
    List<AlumnoAsistenciaSala> getAlumnosByScheduleAndUser(String username, String idHorario);
}
