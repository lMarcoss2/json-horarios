package edu.calc.becas.mconfiguracion.cicloescolar.model;

import edu.calc.becas.common.model.CommonData;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@ApiModel(description = "Entidad con los datos del ciclo escolar")
public class CicloEscolarVo extends CommonData {
    @ApiModelProperty("Identificador único del ciclo escolar")
    private int idCicloEscolar;

    @ApiModelProperty("descripción del ciclo escolar")
    private String descripcionCiclo;

    @ApiModelProperty("Indica si es periodo en curso")
    private String periodoActual;

    @ApiModelProperty("Indica si es periodo en curso (descripción)")
    private String desPeriodoActual;

    public CicloEscolarVo(String estatus) {
        super((estatus));
    }

    @Override
    public String toString() {
        return "CicloEscolarVo{" +
                "idCicloEscolar=" + idCicloEscolar +
                ", descripcionCiclo='" + descripcionCiclo + '\'' +
                ", periodoActual='" + periodoActual + '\'' +
                ", desPeriodoActual='" + desPeriodoActual + '\'' +
                '}';
    }
}
