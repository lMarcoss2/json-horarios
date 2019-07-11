package edu.calc.becas.malumnos.dao;

public class QueriesAlumnos {

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

    static final String QRY_ADD = "INSERT INTO ALUMNOS (ID_ALUMNO, MATRICULA, NOMBRES, APE_PATERNO, APE_MATERNO, ESTATUS, FECHA_CREACION, AGREGADO_POR) VALUES\n" +
            "(?,?,?,?,?,?,CURDATE(),?)";

    static final String QRY_ADD_ALUMNO_ACTIVIDAD = "INSERT INTO ACTIVIDAD_ALUMNO (ID_ACTIVIDAD, ID_ALUMNO, ID_GRUPO, AGREGADO_POR, FECHA_CREACION) VALUES\n" +
            "(?, ?, ?,'ADMIN',CURDATE())";

    static final String QRY_ID_ALUMNO = "SELECT max(ID_ALUMNO)+1 FROM ALUMNOS";
}
