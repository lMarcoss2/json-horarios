package edu.calc.json.horarios.malumnos.actividades.model;

import edu.calc.json.horarios.common.model.CommonData;
import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@ApiModel(value="Actividades de alumnos", description = "Entidad con lo datos de las actividades con los alumnos")
public class ActividadesAlumnos extends CommonData {
  private int idActividad;
  private String nombreActividad;
  private String idAlumno;
  private String matricula;
  private String nombre;
  private String aPaterno;
  private String aMaterno;

  public ActividadesAlumnos(){

  }

  public ActividadesAlumnos(String estatus){
    super(estatus);
  }

}
