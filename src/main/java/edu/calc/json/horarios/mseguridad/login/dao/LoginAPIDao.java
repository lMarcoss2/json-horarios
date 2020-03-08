package edu.calc.json.horarios.mseguridad.login.dao;

import edu.calc.json.horarios.exceptions.GenericException;
import edu.calc.json.horarios.mseguridad.usuarios.model.Usuario;

public interface LoginAPIDao {

  Usuario login(String username, String password) throws GenericException;
}
