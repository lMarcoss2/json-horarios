package edu.calc.becas.mconfiguracion.login.service;

import edu.calc.becas.mconfiguracion.login.dao.LoginAPIDaoImpl;
import edu.calc.becas.mseguridad.usuarios.model.Usuario;
import org.springframework.stereotype.Service;

@Service
public class LoginAPIServiceImpl implements LoginAPIService {

  private final LoginAPIDaoImpl loginAPIDaoImpl;

  public LoginAPIServiceImpl(LoginAPIDaoImpl loginAPIDaoImpl){
    this.loginAPIDaoImpl = loginAPIDaoImpl;
  }

  @Override
  public Usuario login(String username, String password) {
    return loginAPIDaoImpl.login(username, password);
  }
}
