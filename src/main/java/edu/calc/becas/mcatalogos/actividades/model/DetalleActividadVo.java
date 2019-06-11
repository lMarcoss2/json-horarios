package edu.calc.becas.mcatalogos.actividades.model;

import edu.calc.becas.common.model.CommonData;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class DetalleActividadVo extends CommonData {
    private int idDetalleActividad;
    private int hora;
    private String format;
    private int numeroAlumnos;
    private String nombreActividad;
    private String cicloEscolar;
    public DetalleActividadVo(){};

    public DetalleActividadVo(String estatus) {
        super((estatus));
    }
}
