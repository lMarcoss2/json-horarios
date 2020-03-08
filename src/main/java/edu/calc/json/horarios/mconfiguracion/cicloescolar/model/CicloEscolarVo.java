package edu.calc.json.horarios.mconfiguracion.cicloescolar.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@ApiModel(description = "Entidad con los datos del Periodo actual")
public class CicloEscolarVo {

    @ApiModelProperty("Clave del periodo")
    private String clave;

    @ApiModelProperty("Nombre del periodo")
    private String nombre;

    @ApiModelProperty("Tipo Periodo")
    private String tipo;

    @ApiModelProperty("Fecha de Inicio del periodo")
    private String fechaInicio;

    @ApiModelProperty("Fecha fin del periodo")
    private String fechaFin;

}
