package edu.calc.becas.reporte.asistencia.sala.service;

import edu.calc.becas.reporte.asistencia.sala.model.AlumnoAsistenciaSala;
import edu.calc.becas.reporte.asistencia.sala.model.FechaAsistencia;

import java.util.List;

public interface AsistenciaSalaService {
    List<AlumnoAsistenciaSala> getAlumnosByScheduleAndUser(String username, String idHorario);

    void getPresenceByDate(List<AlumnoAsistenciaSala> alumnos, List<FechaAsistencia> fechas);
}
