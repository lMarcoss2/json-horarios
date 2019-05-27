package edu.calc.becas.malumnos.model;

import edu.calc.becas.common.model.CommonData;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author Marcos Santiago Leonardo
 * Universidad de la Sierra Sur (UNSIS)
 * Description:
 * Date: 5/13/19
 */
@NoArgsConstructor
@Setter
@Getter
public class Alumno extends CommonData {
    private String IdAlumno;
    private String matricula;
    private String nombres;
    private String apePaterno;
    private String apeMaterno;
    private String hrs;

}
