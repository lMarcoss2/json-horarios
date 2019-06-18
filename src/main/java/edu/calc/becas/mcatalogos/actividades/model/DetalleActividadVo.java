package edu.calc.becas.mcatalogos.actividades.model;

import edu.calc.becas.common.model.CommonData;
import edu.calc.becas.mseguridad.usuarios.model.Usuario;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@ApiModel(value = "DetalleActividad", description = "Entidad con los horarios y detalle de cada acttividad")
public class DetalleActividadVo extends CommonData {
    @ApiModelProperty("Identificador único de detalle actividad")
    private int idDetalleActividad;

    @ApiModelProperty("Horario de la actidad")
    private String hora;

    @ApiModelProperty("Indica la hora en AM/PM")
    private String format;

    @ApiModelProperty("Número de alumnos inscriptos a la actividad")
    private int numeroAlumnos;

    @ApiModelProperty("Nombre de la actividad")
    private String nombreActividad;

    @ApiModelProperty("Indica el ciclo escolar de la actividad")
    private String cicloEscolar;

    @ApiModelProperty("Identificador único de la actividad")
    private String idActividad;

    @ApiModelProperty("Encargado o responsable de la actividad")
    private Usuario usuario;

    public DetalleActividadVo() {
    }

    public DetalleActividadVo(String estatus) {
        super((estatus));
    }
}
