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

    static final String QRY_GET_ALL = "SELECT * FROM PARCIALES";
    static final String QRY_INACTIVE_ESTATUS = "UPDATE PARCIALES SET PARCIAL_ACTUAL = 'N' WHERE ID_PARCIAL != ?";
    static final String QRY_ACTIVE_ESTATUS = "UPDATE PARCIALES SET PARCIAL_ACTUAL = 'S' WHERE ID_PARCIAL = ?";

}
