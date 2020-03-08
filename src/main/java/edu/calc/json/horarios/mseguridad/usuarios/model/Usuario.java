package edu.calc.json.horarios.mseguridad.usuarios.model;

import edu.calc.json.horarios.common.model.CommonData;
import edu.calc.json.horarios.mseguridad.rolesypermisos.model.Rol;
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
@ApiModel(description = "Entidad con los datos del usuario")
public class Usuario extends CommonData implements Serializable {
    @ApiModelProperty("Indentificador único del usuario")
    private int idUsuario;
    @ApiModelProperty(value = "Nombre (s) del usuario", required = true)
    private String nombres;
    @ApiModelProperty(value = "Apellido paterno del usuario", required = true)
    private String apePaterno;

    @ApiModelProperty(value = "Apellido materno del usuario")
    private String apeMaterno;

    @ApiModelProperty(value = "Tipo de usuario: Rol", required = true)
    private String tipoUsuario;

    private Rol rol;

    @ApiModelProperty(value = "correo del usuario para sesión", required = true)
    private String username;
    @ApiModelProperty("Contraseña del usuario")
    private String password;

    public Usuario(String estatus) {
        super(estatus);
    }
}
