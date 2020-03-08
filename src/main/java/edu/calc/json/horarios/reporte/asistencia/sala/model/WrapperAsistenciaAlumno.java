package edu.calc.json.horarios.reporte.asistencia.sala.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class WrapperAsistenciaAlumno implements Serializable {
    private List<FechaAsistencia> fechas;
    List<AlumnoAsistenciaSala> alumnos;

}
