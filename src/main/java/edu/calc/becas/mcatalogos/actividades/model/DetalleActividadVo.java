package edu.calc.becas.mcatalogos.actividades.model;

import edu.calc.becas.common.model.CommonData;
import edu.calc.becas.mseguridad.usuarios.model.Usuario;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.apache.catalina.User;

@Getter
@Setter
@ToString
public class DetalleActividadVo extends CommonData {
    private int idDetalleActividad;
    private String hora;
    private String format;
    private int numeroAlumnos;
    private String nombreActividad;
    private String cicloEscolar;
    private String idActividad;
    private Usuario usuario;
    public DetalleActividadVo(){};

    public DetalleActividadVo(String estatus) {
        super((estatus));
    }
}
