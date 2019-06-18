package edu.calc.becas.mcatalogos.grupos.model;

import edu.calc.becas.common.model.CommonData;
import edu.calc.becas.mcatalogos.licenciaturas.model.Licenciatura;
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
@ApiModel(description = "Entidad con los datos del grupo")
public class Grupo extends CommonData {
    @ApiModelProperty("Identificador único del grupo")
    private int idGrupo;
    @ApiModelProperty(value = "Clave del grupo", required = true)
    private String cveGrupo;

    @ApiModelProperty(value = "Licenciatura del grupo", required = true)
    private Licenciatura licenciatura;

    public Grupo(String estatus) {
        super(estatus);
    }
}
