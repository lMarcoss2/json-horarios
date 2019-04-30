package edu.calc.becas.mseguridad.usuarios.model;

import edu.calc.becas.common.model.CommonData;
import lombok.Getter;
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
public class Usuario extends CommonData implements Serializable {
    private int idUsuario;
    private String nombres;
    private String apePaterno;
    private String apeMaterno;
    private String tipoUsuario;
    private String username;
    private String password;

    public Usuario(String estatus) {
        super(estatus);
    }
}
