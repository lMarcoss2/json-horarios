package edu.calc.json.horarios.mseguridad.login.api;

import edu.calc.json.horarios.exceptions.GenericException;
import edu.calc.json.horarios.mseguridad.login.service.LoginAPIService;
import edu.calc.json.horarios.mseguridad.usuarios.model.Usuario;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
@Api(description = "Servicios para realizar el login de la aplicación")
public class LoginAPI {

  private final LoginAPIService loginAPIService;

  public LoginAPI(LoginAPIService loginAPIService) {
    this.loginAPIService = loginAPIService;
  }


  @PostMapping
  @ApiOperation(value = "Realiza el login del usuario validando el usuario y contraseña")
  public Usuario login(@ApiParam(value= "Usuario en sesión", defaultValue = "0")
                              @RequestBody Usuario user) throws GenericException {
    return loginAPIService.login(user.getUsername(), user.getUsername());
  }
}
