package edu.calc.becas.mcatalogos.actividades.model;


import edu.calc.becas.common.model.CommonData;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ActividadVo extends CommonData {
    private int idActividad;
    private String nombreActividad;
    private String cicloEscolar;
    private String obligatorio;
    private int numeroAlumnos;

    public ActividadVo(){};

    public ActividadVo(String estatus) {
        super((estatus));
    }

}
