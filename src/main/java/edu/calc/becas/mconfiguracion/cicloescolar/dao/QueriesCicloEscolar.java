package edu.calc.becas.mconfiguracion.cicloescolar.dao;

public class QueriesCicloEscolar {
    public static final String QRY_CICLO_ESCOLAR = "SELECT ID_CICLO_ESCOLAR, DESCRIPCION_CICLO, PERIODO_ACTUAL, ESTATUS FROM CICLO_ESCOLAR";
    public static final String QRY_ADD = "INSERT INTO CICLO_ESCOLAR (DESCRIPCION_CICLO, PERIODO_ACTUAL, ESTATUS, AGREGADO_POR, FECHA_CREACION)\n" +
            "VALUES (?,'S',?,'admin',CURDATE())";

    public static final String QRY_LIST_CICLO = "SELECT ID_CICLO_ESCOLAR, DESCRIPCION_CICLO FROM CICLO_ESCOLAR";
}

