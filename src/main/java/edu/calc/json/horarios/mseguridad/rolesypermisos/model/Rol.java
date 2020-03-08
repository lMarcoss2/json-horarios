package edu.calc.json.horarios.mseguridad.rolesypermisos.model;

import edu.calc.json.horarios.common.model.CommonData;
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
 * Date: 4/14/19
 */
@Setter
@Getter
@NoArgsConstructor
@ApiModel(description = "Entidad con los datos del Rol")
public class Rol extends CommonData implements Serializable {
    @ApiModelProperty("Indentificador único del Rol")
    private int idRol;
    @ApiModelProperty(value = "Nombre del rol", required = true)
    private String nombre;

    public Rol(String estatus) {
        super(estatus);
    }
}
