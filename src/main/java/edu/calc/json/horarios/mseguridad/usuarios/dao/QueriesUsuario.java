package edu.calc.json.horarios.mseguridad.usuarios.dao;

/**
 * @author Marcos Santiago Leonardo
 * Universidad de la Sierra Sur (UNSIS)
 * Description:
 * Date: 4/14/19
 */
final class QueriesUsuario {
    private QueriesUsuario() {
    }

    static final String QRY_GET_ALL = "SELECT U.ID_USUARIO, U.NOMBRES, U.APE_PATERNO, U.APE_MATERNO,  U.USERNAME, U.ESTATUS, R.NOMBRE_ROL TIPO_USUARIO\n" +
            "FROM USUARIOS U, ROLES R WHERE U.ID_ROL = R.ID_ROL ";
    static final String QRY_CONDITION_ESTATUS = "\nAND U.ESTATUS = ? ";
    static final String QRY_CONDITION_TIPO_USUARIO = "\nAND U.ID_ROL = ?";
    static final String QRY_ADD =
            "INSERT INTO USUARIOS\n" +
                    "(NOMBRES, APE_PATERNO, APE_MATERNO, TIPO_USUARIO, USERNAME, PASSWORD, ESTATUS, AGREGADO_POR, FECHA_CREACION)\n" +
                    "  VALUE (?, ?, ?, ?, ?, sha2(concat(?, ?, ?), 224), ?, ?, NOW())";

    static final String QRY_UPDATE =
            "UPDATE USUARIOS\n" +
                    "SET NOMBRES = ?, APE_PATERNO = ?, APE_MATERNO = ?, TIPO_USUARIO = ?, USERNAME = ?,\n" +
                    "  ESTATUS   = ?, ACTUALIZADO_POR = ?, FECHA_ACTUALIZACION = NOW() \n" +
                    "WHERE ID_USUARIO = ?";

    static final String QRY_UPDATE_WITH_PASSWORD =
            "UPDATE USUARIOS\n" +
                    "SET NOMBRES = ?, APE_PATERNO = ?, APE_MATERNO = ?, TIPO_USUARIO = ?, USERNAME = ?, PASSWORD = sha2(concat(?, ?, ?), 224),\n" +
                    "  ESTATUS   = ?, ACTUALIZADO_POR = ?, FECHA_ACTUALIZACION = NOW()\n" +
                    "WHERE ID_USUARIO = ?";

    static final String QRY_ORDER_BY = "\nORDER BY NOMBRES ASC, APE_PATERNO ASC, APE_MATERNO ASC";
}
