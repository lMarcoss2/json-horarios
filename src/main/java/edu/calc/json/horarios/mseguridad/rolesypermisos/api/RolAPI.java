package edu.calc.json.horarios.mseguridad.rolesypermisos.api;

import edu.calc.json.horarios.common.model.WrapperData;
import edu.calc.json.horarios.mseguridad.rolesypermisos.service.RolService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import static edu.calc.json.horarios.common.utils.Constant.*;

/**
 * @author Marcos Santiago Leonardo
 * Universidad de la Sierra Sur (UNSIS)
 * Description: API para exponer servicios de administración de roles de usuario
 * Date: 4/14/19
 */
@RestController
@RequestMapping("/roles")
@Api(description = "Servicios para administración de seguridad de la aplicación")
public class RolAPI {

    private final RolService rolService;

    @Autowired
    public RolAPI(RolService rolService) {
        this.rolService = rolService;
    }


    @GetMapping
    @ApiOperation(value = "Obtiene el listado de roles")
    public WrapperData getAllRoles(
            @ApiParam(value = "Página a recuperar", defaultValue = DEFAULT_PAGE) @RequestParam(value = "page", defaultValue = DEFAULT_PAGE, required = false) String page,
            @ApiParam(value = "Registros a recuperar", defaultValue = ALL_ITEMS) @RequestParam(value = "pageSize", defaultValue = ALL_ITEMS, required = false) String pageSize,
            @ApiParam(value = "Estatus de los registros a recuperar", defaultValue = DEFAULT_ESTATUS) @RequestParam(value = "status", defaultValue = DEFAULT_ESTATUS, required = false) String status) {
        if (pageSize.equalsIgnoreCase(ALL_ITEMS)) {
            pageSize = ITEMS_FOR_PAGE;
        }
        return this.rolService.getAllByStatus(Integer.parseInt(page), Integer.parseInt(pageSize), status);
    }
}
