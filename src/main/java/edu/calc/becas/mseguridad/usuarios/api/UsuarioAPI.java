package edu.calc.becas.mseguridad.usuarios.api;

import edu.calc.becas.common.model.WrapperData;
import edu.calc.becas.mseguridad.usuarios.service.UsuarioService;
import edu.calc.becas.mseguridad.usuarios.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import static edu.calc.becas.common.utils.Constant.DEFAULT_PAGE;
import static edu.calc.becas.common.utils.Constant.ESTATUS_DEFAULT;
import static edu.calc.becas.common.utils.Constant.ITEMS_FOR_PAGE;

/**
 * @author Marcos Santiago Leonardo
 * Universidad de la Sierra Sur (UNSIS)
 * Description: API para exponer servicios de administración de usuwarios
 * Date: 4/14/19
 */
@RestController
@RequestMapping("/usuarios")
public class UsuarioAPI {

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
    public Usuario add(@RequestBody Usuario usuario) {
        usuario.setAgregadoPor("Admin");
        return this.usuarioService.add(usuario);
    }

    @PatchMapping
    public Usuario update(@RequestBody Usuario usuario) {
        usuario.setActualizadoPor("Admin");
        return this.usuarioService.update(usuario);
    }
}
