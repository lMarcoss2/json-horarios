package edu.calc.json.horarios.mcatalogos.periodo.model;

import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@ApiModel(description = "Entidad con los datos del Periodo actual")
public class Periodo {

    private String clave;
    private String fFin;
    private String fInicio;
    private String nombre;
    private String tipo;
}
