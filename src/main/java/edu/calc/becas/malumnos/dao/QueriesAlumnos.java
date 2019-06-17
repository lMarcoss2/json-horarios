package edu.calc.becas.malumnos.dao;

public class QueriesAlumnos {

    static final String QRY_COUNT_ITEM = "SELECT COUNT(1) FROM ALUMNOS AL WHERE 1 = 1 ";
    static final String QRY_GET_ALL = "SELECT AL.*, AC.ID_ACTIVIDAD, AC.NOMBRE_ACTIVIDAD\n" +
            "  FROM ALUMNOS AL,\n" +
            "      ACTIVIDAD_ALUMNO ACAL,\n" +
            "      ACTIVIDADES AC\n" +
            "WHERE 1 = 1 AND AL.ID_ALUMNO = ACAL.ID_ALUMNO\n" +
            "AND ACAL.ID_ACTIVIDAD = AC.ID_ACTIVIDAD";
    static final String QRY_CONDITION_MATRICULA = "\nAND AL.MATRICULA = ?";
    static final String QRY_CONDITION_ESTATUS = " AND AL.ESTATUS = ? ";
    static final String QRY_CONDITION_ACTIVIDAD = "AND ACAL.ID_ACTIVIDAD = ? ";
    static final String QRY_ORDER_BY_NOMBRE_ALUMNO = "\nORDER BY APE_PATERNO, APE_MATERNO, NOMBRES ASC\n";


    //SELECT ID_ALUMNO, MATRICULA, NOMBRES, APE_PATERNO, APE_MATERNO, ESTATUS FROM ALUMNOS;
}
