package edu.calc.becas.mseguridad.usuarios.api;

import edu.calc.becas.common.model.WrapperData;
import edu.calc.becas.exceptions.GenericException;
import edu.calc.becas.mseguridad.usuarios.model.Usuario;
import edu.calc.becas.mseguridad.usuarios.service.UsuarioService;
import edu.calc.becas.utils.DecryptUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import static edu.calc.becas.common.utils.Constant.*;

/**
 * @author Marcos Santiago Leonardo
 * Universidad de la Sierra Sur (UNSIS)
 * Description: API para exponer servicios de administración de usuwarios
 * Date: 4/14/19
 */
@RestController
@RequestMapping("/usuarios")
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
    public WrapperData getAll(@RequestParam(value = "page", defaultValue = DEFAULT_PAGE, required = false) String page,
                              @RequestParam(value = "pageSize", defaultValue = ITEMS_FOR_PAGE, required = false) String pageSize,
                              @RequestParam(value = "status", defaultValue = ESTATUS_DEFAULT, required = false) String status) {
        return this.usuarioService.getAll(Integer.parseInt(page), Integer.parseInt(pageSize), status);
    }

    @PostMapping
    public Usuario add(@RequestBody Usuario usuario) throws GenericException {
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
    public Usuario update(@RequestBody Usuario usuario) throws GenericException {
        usuario.setActualizadoPor("Admin");
        validatePassword(usuario);
        return this.usuarioService.update(usuario);
    }
}
