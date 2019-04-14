package edu.calc.becas.mconfiguracion.parciales.model;

import edu.calc.becas.common.model.CommonData;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

/**
 * @author Marcos Santiago Leonardo
 * Universidad de la Sierra Sur (UNSIS)
 * Description:
 * Date: 4/9/19
 */
@NoArgsConstructor
@Setter
@Getter
public class Parcial extends CommonData implements Serializable {
    private int idParcial;
    private String descParcial;
    private boolean parcialActual;

}
