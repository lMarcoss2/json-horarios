package edu.calc.becas.malumnos.dao;

public class QueriesAlumnos {


    static final String QRY_GET_ALL = "SELECT AL.*, AA.ID_ACTIVIDAD\n" +
            "FROM ALUMNOS AL, ALUMNOS_DAT_PERIODO ADP, ACTIVIDAD_ALUMNO AA\n" +
            "WHERE AL.MATRICULA = ADP.MATRICULA\n" +
            "  AND ADP.CVE_PERIODO = '1819A'\n" +
            "  AND ADP.CVE_GRUPO = AA.CVE_GRUPO\n" +
            "  AND ADP.CVE_LICENCIATURA = AA.CVE_LICENCIATURA\n" +
            "  AND ADP.CVE_PERIODO = AA.CVE_PERIODO\n" +
            "  AND AL.ESTATUS = 'S'\n" +
            "  AND AA.ID_ACTIVIDAD = 2\n";

    static final String QRY_CONDITION_MATRICULA = "\nAND AL.MATRICULA = ?";
    static final String QRY_CONDITION_ESTATUS = " AND AL.ESTATUS = ? ";
    static final String QRY_CONDITION_ACTIVIDAD = "AND ACAL.ID_ACTIVIDAD = ? ";
    static final String QRY_ORDER_BY_NOMBRE_ALUMNO = "\nORDER BY APE_PATERNO, APE_MATERNO, NOMBRES ASC\n";

    static final String QRY_ADD = "INSERT INTO ALUMNOS (ID_ALUMNO, CURP, MATRICULA, NOMBRES, APE_PATERNO, APE_MATERNO, ESTATUS, FECHA_CREACION, AGREGADO_POR) VALUES\n" +
            "(?,?,?,?,?,?,?,CURDATE(),?)";

    static final String QRY_ADD_ALUMNO_ACTIVIDAD = "INSERT INTO ACTIVIDAD_ALUMNO (ID_ACTIVIDAD, MATRICULA, AGREGADO_POR, FECHA_CREACION) VALUES\n" +
            "(?, ?,'ADMIN',CURDATE())";

    static final String QRY_ID_ALUMNO = "SELECT max(ID_ALUMNO)+1 FROM ALUMNOS";


}
