package edu.calc.json.horarios.mcatalogos.grupos.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author Marcos Santiago Leonardo
 * Universidad de la Sierra Sur (UNSIS)
 * Description: model Grupo
 * Date: 3/26/19
 */
@Getter
@Setter
@NoArgsConstructor
@ApiModel(description = "Entidad que representa los datos de un grupo en el perido actual")
public class Grupo {

    @ApiModelProperty(value = "Clave del grupo", required = true)
    private int alumnos;

    @ApiModelProperty(value = "Carrera al que pertenece el grupo", required = true)
    private String carrera;

    @ApiModelProperty(value = "Clave del grupo", required = true)
    private String clave;

    @ApiModelProperty(value = "Nombre grupod", required = true)
    private String nombre;

    @ApiModelProperty(value = "Periodo", required = true)
    private String periodo;

    @ApiModelProperty(value = "Semestre", required = true)
    private int semestre;
}
