package edu.calc.becas.mcatalogos.grupos.model;

import edu.calc.becas.mcatalogos.licenciaturas.model.Licenciatura;
import edu.calc.becas.common.model.CommonData;
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
public class Grupo extends CommonData {
    private int idGrupo;
    private String cveGrupo;
    private Licenciatura licenciatura;

    public Grupo(String estatus) {
        super(estatus);
    }
}
