package edu.calc.json.horarios.mseguridad.rolesypermisos.dao;

/**
 * @author Marcos Santiago Leonardo
 * Universidad de la Sierra Sur (UNSIS)
 * Description:
 * Date: 4/14/19
 */
final class QueriesRol {
    private QueriesRol() {
    }

    static final String QRY_GET_ALL = "SELECT ID_ROL, NOMBRE_ROL, ESTATUS FROM ROLES WHERE 1 = 1 \n";
    static final String QRY_CONDITION_ESTATUS = "\nAND ESTATUS = ?";
    static final String QRY_ORDER_BY = "\nORDER BY NOMBRE_ROL ASC, ESTATUS DESC";
}
