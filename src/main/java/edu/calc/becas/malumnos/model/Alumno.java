package edu.calc.becas.malumnos.model;

import edu.calc.becas.common.model.CommonData;
import edu.calc.becas.mcarga.hrs.blibioteca.model.Hora;
import edu.calc.becas.mcarga.hrs.sala.model.Asistencia;
import edu.calc.becas.mcatalogos.actividades.model.ActividadVo;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * @author Marcos Santiago Leonardo
 * Universidad de la Sierra Sur (UNSIS)
 * Description:
 * Date: 5/13/19
 */
@NoArgsConstructor
@Setter
@Getter
@ToString
public class Alumno extends CommonData {
    private String IdAlumno;
    private String matricula;
    private String nombres;
    private String apePaterno;
    private String apeMaterno;
    private Hora hora;
    private Asistencia asistencia;
    private ActividadVo actividad;

    public Alumno(String estatus){super(estatus);}
}
