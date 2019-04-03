package edu.calc.becas.mcatalogos.licenciaturas.dao;

/**
 * @author Marcos Santiago Leonardo
 * Universidad de la Sierra Sur (UNSIS)
 * Description: define queries for majors
 * Date: 3/23/19
 */
final class QueriesLicenciatura {
    static final String QRY_COUNT_ITEM = "SELECT COUNT(1) FROM LICENCIATURAS WHERE 1 = 1";
    static final String QRY_GET_ALL = "SELECT * FROM LICENCIATURAS WHERE 1 = 1 ";
    static final String QRY_GET_BY_CUSTOM_PARAM = "SELECT * FROM LICENCIATURAS WHERE 1 = 1 ";
    static final String QRY_CONDITION_CVE_LICENCIATURA = "AND CVE_LICENCIATURA = ? ";
    static final String QRY_CONDITION_NOMBRE_LICENCIATURA = " AND NOMBRE_LICENCIATURA = ? ";
    static final String QRY_CONDITION_ESTATUS = " AND ESTATUS = ? ";
    static final String QRY_CONDITION_ID_LICENCIATURA = " AND ID_LICENCIATURA = ? ";
    static final String QRY_CONDITION_AGREGADO_POR = " AND AGREGADO_POR = ? ";
    static final String QRY_CONDITION_ACTUALIZADO_POR = " AND ACTUALIZADO_POR = ? ";
    static final String QRY_ADD =
            "INSERT INTO LICENCIATURAS (CVE_LICENCIATURA, NOMBRE_LICENCIATURA, ESTATUS, AGREGADO_POR, FECHA_CREACION)\n" +
                    "  VALUE (?, ?, ?, ?, NOW())";
    static final String QRY_UPDATE =
            "UPDATE LICENCIATURAS SET CVE_LICENCIATURA = ?, NOMBRE_LICENCIATURA = ?, ESTATUS = ?, ACTUALIZADO_POR = ?, FECHA_ACTUALIZACION = NOW() WHERE ID_LICENCIATURA = ?";
}
