package edu.calc.json.horarios.common.model;

import edu.calc.json.horarios.common.utils.Constant;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

/**
 * @author Marcos Santiago Leonardo
 * Universidad de la Sierra WSur (UNSIS)
 * Description: Common class for properties definition of objects
 * Date: 3/23/19
 */
@Setter
@Getter
@NoArgsConstructor
public class CommonData implements Serializable {
    @ApiModelProperty(value = "Clave del estatus S/N", required = true)
    private String estatus;
    @ApiModelProperty("Descripción el estatus (Activo/Inactivo)")
    private String descEstatus;
    @ApiModelProperty("Nombre de usuario creador")
    private String agregadoPor;
    @ApiModelProperty("Fecha de creación")
    private String fechaCreacion;
    @ApiModelProperty("Nombre de usuario que edita")
    private String actualizadoPor;
    @ApiModelProperty("Fecha de actualización")
    private String fechaActualizacion;

    public CommonData(String estatus) {
        this.estatus = estatus;
        if (this.estatus.equals(Constant.ESTATUS_ACTIVE)) {
            this.descEstatus = "Activo";
        } else if (this.estatus.equals(Constant.ESTATUS_INACTIVE)) {
            this.descEstatus = "Inactivo";
        }
    }
}
