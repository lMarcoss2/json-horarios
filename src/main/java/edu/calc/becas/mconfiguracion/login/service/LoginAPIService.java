package edu.calc.becas.mconfiguracion.login.service;

import edu.calc.becas.mseguridad.usuarios.model.Usuario;

public interface LoginAPIService {

  Usuario login(String username, String password);
}
