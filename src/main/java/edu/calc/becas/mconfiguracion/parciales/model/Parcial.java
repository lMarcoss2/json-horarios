package edu.calc.becas.mconfiguracion.parciales.model;

import edu.calc.becas.common.model.CommonData;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
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
@ApiModel(description = "Entidad con los datos del parcial")
public class Parcial extends CommonData implements Serializable {
    @ApiModelProperty("Indentificador único de parcial")
    private int idParcial;

    @ApiModelProperty("Descripción de parcial")
    private String descParcial;

    @ApiModelProperty("Indica si el parcial es el actual")
    private boolean parcialActual;

}
