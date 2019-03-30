package edu.calc.becas.catalogos.actividades.dao;

public interface QueriesActividades {

  public static final String QRY_COUNT_ITEM = "SELECT COUNT(1) FROM ACTIVIDADES";

  public static String QRY_ACTIVIDADES = "SELECT AC.ID_ACTIVIDAD, AC.NOMBRE_ACTIVIDAD,\n"+
    "      (SELECT DESCRIPCION_CICLO FROM CICLO_ESCOLAR WHERE ID_CICLO_ESCOLAR = AC.ID_CICLO_ESCOLAR)CICLO_ESCOLAR,\n"+
    "       AC.OBLIGATORIO, AC.NUMERO_ALUMNOS,\n"+
    "       CASE WHEN AC.ESTATUS = 'S' THEN 'ACTIVO' WHEN  AC.ESTATUS = 'N' THEN 'INACTIVO' END AS ESTATUS\n"+
    "FROM ACTIVIDADES AC";

}
