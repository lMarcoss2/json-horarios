package edu.calc.becas.catalogos.actividades.model;


import edu.calc.becas.common.model.CommonData;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ActividadesVo extends CommonData {
  private int idActividad;
  private String nombreArchivo;
  private String cicloEscolar;
  private String obligatorio;
  private int numeroAlumnos;

  public ActividadesVo(String estatus){super((estatus));}

}
