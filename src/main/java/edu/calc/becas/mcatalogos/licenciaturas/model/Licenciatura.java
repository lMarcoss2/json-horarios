package edu.calc.becas.mcatalogos.licenciaturas.model;

import edu.calc.becas.common.model.CommonData;
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
public class Licenciatura extends CommonData {
    private int idLicenciatura;
    private String cveLicenciatura;
    private String nombreLicenciatura;

    public Licenciatura(String estatus) {
        super(estatus);
    }

}
