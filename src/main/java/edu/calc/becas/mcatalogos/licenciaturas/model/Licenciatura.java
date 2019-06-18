package edu.calc.becas.mcatalogos.licenciaturas.model;

import edu.calc.becas.common.model.CommonData;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author Marcos Santiago Leonardo
 * Universidad de la Sierra Sur (UNSIS)
 * Description:
 * Date: 3/23/19
 */
@Getter
@Setter
@NoArgsConstructor
@ApiModel(description = "Entidad con los datos de la licenciatura")
public class Licenciatura extends CommonData {

    @ApiModelProperty(notes = "Identificador único de la licenciatura")
    private int idLicenciatura;
    @ApiModelProperty(notes = "Clave de la licenciatura", required = true)
    private String cveLicenciatura;
    @ApiModelProperty(notes = "Nombre de la licenciatura", required = true)
    private String nombreLicenciatura;

    public Licenciatura(String estatus) {
        super(estatus);
    }

}
