package edu.calc.json.horarios.mcatalogos.licenciaturas.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

/**
 * @author Marcos Santiago Leonardo
 * Universidad de la Sierra Sur (UNSIS)
 * Description:
 * Date: 08/03/20
 */
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ListCarreras implements Serializable {
    private List<Licenciatura> licenciaturas;
}
