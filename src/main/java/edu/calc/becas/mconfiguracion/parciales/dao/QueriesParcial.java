package edu.calc.becas.mconfiguracion.parciales.dao;

/**
 * @author Marcos Santiago Leonardo
 * Universidad de la Sierra Sur (UNSIS)
 * Description:
 * Date: 4/9/19
 */
final class QueriesParcial {
    private QueriesParcial() {
    }

    static final String QRY_GET_ALL = "SELECT ID_PARCIAL, DESC_PARCIAL, PARCIAL_ACTUAL,\n" +
            "       DATE_FORMAT(FECHA_INICIO, '%d/%m/%Y') AS FECHA_INICIO,\n" +
            "       DATE_FORMAT(FECHA_FIN, '%d/%m/%Y') AS FECHA_FIN,\n" +
            "       CVE_PERIODO, DESC_PERIODO\n" +
            "FROM PARCIALES WHERE CVE_PERIODO = ?";
    static final String QRY_GET_PARCIAL_ACTUAL = "SELECT * FROM PARCIALES WHERE PARCIAL_ACTUAL = 'S'";
    static final String QRY_INACTIVE_ESTATUS = "UPDATE PARCIALES SET PARCIAL_ACTUAL = 'N' WHERE ID_PARCIAL != ?";
    static final String QRY_ACTIVE_ESTATUS = "UPDATE PARCIALES SET PARCIAL_ACTUAL = 'S' WHERE ID_PARCIAL = ?";

}
