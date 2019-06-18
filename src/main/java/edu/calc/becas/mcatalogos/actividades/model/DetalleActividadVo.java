package edu.calc.becas.mcatalogos.actividades.model;

import edu.calc.becas.common.model.CommonData;
import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@ApiModel(value = "DetalleActividad", description = "Entidad con los horarios y detalle de cada acttividad")
public class DetalleActividadVo extends CommonData {
    private int idDetalleActividad;
    private int hora;
    private String format;
    private int numeroAlumnos;
    private String nombreActividad;
    private String cicloEscolar;
    private String idActividad;
    public DetalleActividadVo(){};

    public DetalleActividadVo(String estatus) {
        super((estatus));
    }
}
