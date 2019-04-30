package edu.calc.becas.mseguridad.usuarios.service;

import edu.calc.becas.common.model.WrapperData;
import edu.calc.becas.mseguridad.usuarios.model.Usuario;

/**
 * @author Marcos Santiago Leonardo
 * Universidad de la Sierra Sur (UNSIS)
 * Description:
 * Date: 4/14/19
 */
public interface UsuarioService {
    WrapperData getAll(int page, int pageSize, String status);

    Usuario add(Usuario usuario);

    Usuario update(Usuario usuario);
}
