package edu.calc.becas.mcatalogos.actividades.dao;

final class QueriesActividades {
    private QueriesActividades() {
    }

    static final String QRY_COUNT_ITEM = "SELECT COUNT(1) FROM ACTIVIDADES";

    static String QRY_ACTIVIDADES = "SELECT AC.ID_ACTIVIDAD, AC.NOMBRE_ACTIVIDAD,\n" +
            "      (SELECT DESCRIPCION_CICLO FROM CICLO_ESCOLAR WHERE ID_CICLO_ESCOLAR = AC.ID_CICLO_ESCOLAR)CICLO_ESCOLAR,\n" +
            "       CASE WHEN  AC.OBLIGATORIO = 'S' THEN 'SI' WHEN AC.OBLIGATORIO = 'N' THEN 'NO' END AS OBLIGATORIO, AC.NUMERO_ALUMNOS,\n" +
            "       AC.ESTATUS " +
            "FROM ACTIVIDADES AC";

  public static String QRY_ADD = "INSERT INTO CICLO_ESCOLAR (DESCRIPCION_CICLO, PERIODO_ACTUAL, ESTATUS, AGREGADO_POR, FECHA_CREACION)\n" +
          "VALUES ('2019-2019A','S','S','admin',CURDATE());";

}
