package edu.calc.becas.mconfiguracion.cicloescolar.model;

import edu.calc.becas.common.model.CommonData;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CicloEscolarVo extends CommonData {
 private int idCicloEscolar;
 private String descripcionCiclo;
 private String periodoActual;
 private String desPeriodoActual;

 public CicloEscolarVo(String estatus){super((estatus));}

 @Override
 public String toString() {
  return "CicloEscolarVo{" +
          "idCicloEscolar=" + idCicloEscolar +
          ", descripcionCiclo='" + descripcionCiclo + '\'' +
          ", periodoActual='" + periodoActual + '\'' +
          ", desPeriodoActual='" + desPeriodoActual + '\'' +
          '}';
 }
}
