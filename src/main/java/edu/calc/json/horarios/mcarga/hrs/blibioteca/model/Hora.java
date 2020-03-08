package edu.calc.json.horarios.mcarga.hrs.blibioteca.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * @author Marcos Santiago Leonardo
 * Universidad de la Sierra Sur (UNSIS)
 * Description:
 * Date: 6/4/19
 */
@NoArgsConstructor
@Setter
@Getter
@ToString
public class Hora implements Serializable {
    int numHora;
    int numMinutos;
}
