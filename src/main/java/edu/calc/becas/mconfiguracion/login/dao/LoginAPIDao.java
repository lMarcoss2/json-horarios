package edu.calc.becas.mconfiguracion.login.dao;

import edu.calc.becas.mseguridad.usuarios.model.Usuario;

public interface LoginAPIDao {

  Usuario login(String username, String password);
}
