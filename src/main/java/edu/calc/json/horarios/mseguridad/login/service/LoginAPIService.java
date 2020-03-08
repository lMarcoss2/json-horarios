package edu.calc.json.horarios.mseguridad.login.service;

import edu.calc.json.horarios.exceptions.GenericException;
import edu.calc.json.horarios.mseguridad.usuarios.model.Usuario;

public interface LoginAPIService {

  Usuario login(String username, String password) throws GenericException;
}
