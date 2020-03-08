package edu.calc.json.horarios.mseguridad.usuarios.api;

import edu.calc.json.horarios.common.model.WrapperData;
import edu.calc.json.horarios.exceptions.GenericException;
import edu.calc.json.horarios.mseguridad.usuarios.model.Usuario;
import edu.calc.json.horarios.mseguridad.usuarios.service.UsuarioService;
import edu.calc.json.horarios.utils.DecryptUtil;
import edu.calc.json.horarios.common.utils.Constant;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

/**
 * @author Marcos Santiago Leonardo
 * Universidad de la Sierra Sur (UNSIS)
 * Description: API para exponer servicios de administración de usuwarios
 * Date: 4/14/19
 */
@RestController
@RequestMapping("/usuarios")
@Api(description = "Servicios para administración de usuarios")
public class UsuarioAPI {

    private static final Logger LOG = LoggerFactory.getLogger(UsuarioAPI.class);

    @Value("${key.encode.crypto}")
    String secretKeyDecrypt;

    private final UsuarioService usuarioService;

    @Autowired
    public UsuarioAPI(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }


    @GetMapping
    @ApiOperation(value = "Obtiene el listado de usuarios")
    public WrapperData getAll(
            @ApiParam(value = "Página a recuperar", defaultValue = Constant.DEFAULT_PAGE) @RequestParam(value = "page", defaultValue = Constant.DEFAULT_PAGE, required = false) String page,
            @ApiParam(value = "Registros a recuperar", defaultValue = Constant.ALL_ITEMS) @RequestParam(value = "pageSize", defaultValue = Constant.ALL_ITEMS, required = false) String pageSize,
            @ApiParam(value = "Estatus de los registros a recuperar", defaultValue = Constant.DEFAULT_ESTATUS) @RequestParam(value = "status", defaultValue = Constant.DEFAULT_ESTATUS, required = false) String status,
            @ApiParam(value = "Tipo de usuario a recuperar", defaultValue = Constant.TIPO_USUARIO_DEFAULT) @RequestParam(value = "tipo-usuario", defaultValue = Constant.TIPO_USUARIO_DEFAULT, required = false) String tipoUsuario) {
        if (pageSize.equalsIgnoreCase(Constant.ALL_ITEMS)) {
            pageSize = Constant.ITEMS_FOR_PAGE;
        }
        return this.usuarioService.getAllByStatusAndOneParam(Integer.parseInt(page), Integer.parseInt(pageSize), status, tipoUsuario);
    }


    @PostMapping
    @ApiOperation(value = "Registra un usuario")
    public Usuario add(@ApiParam(value = "Usuario a registrar", required = true) @RequestBody Usuario usuario) throws GenericException {
        usuario.setAgregadoPor("Admin");
        validatePassword(usuario);
        return this.usuarioService.add(usuario);
    }

    private void validatePassword(Usuario usuario) throws GenericException {
        try {
            String password = usuario.getPassword();
            if (password != null && !password.equalsIgnoreCase("")) {
                usuario.setPassword(DecryptUtil.decrypt(usuario.getPassword(), secretKeyDecrypt, "password"));
            }
        } catch (Exception e) {
            LOG.error(e.getMessage());
            e.printStackTrace();
            throw new GenericException(e.getMessage());
        }
    }

    @PatchMapping
    @ApiOperation(value = "Actualiza datos de un usuario")
    public Usuario update(@ApiParam(value = "Usuario a actualizar", required = true) @RequestBody Usuario usuario) throws GenericException {
        usuario.setActualizadoPor("Admin");
        validatePassword(usuario);
        return this.usuarioService.update(usuario);
    }
}
