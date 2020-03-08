package edu.calc.json.horarios.mseguridad.login.service;

import edu.calc.json.horarios.exceptions.GenericException;
import edu.calc.json.horarios.mseguridad.login.dao.LoginAPIDaoImpl;
import edu.calc.json.horarios.mseguridad.usuarios.model.Usuario;
import org.springframework.stereotype.Service;

@Service
public class LoginAPIServiceImpl implements LoginAPIService {

  private final LoginAPIDaoImpl loginAPIDaoImpl;

  public LoginAPIServiceImpl(LoginAPIDaoImpl loginAPIDaoImpl){
    this.loginAPIDaoImpl = loginAPIDaoImpl;
  }

  @Override
  public Usuario login(String username, String password) throws GenericException {
    return loginAPIDaoImpl.login(username, password);
  }
}
