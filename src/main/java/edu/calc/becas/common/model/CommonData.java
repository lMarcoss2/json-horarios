package edu.calc.becas.common.model;

import edu.calc.becas.common.utils.Constant;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

/**
 * @author Marcos Santiago Leonardo
 * Universidad de la Sierra Sur (UNSIS)
 * Description: Common class for properties definition of objects
 * Date: 3/23/19
 */
@Setter
@Getter
@NoArgsConstructor
public class CommonData implements Serializable {
    private String estatus;
    private String descEstatus;
    private String agregadoPor;
    private String fechaCreacion;
    private String actualizadoPor;
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
