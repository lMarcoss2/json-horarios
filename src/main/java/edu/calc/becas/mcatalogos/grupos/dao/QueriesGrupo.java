package edu.calc.becas.mcatalogos.grupos.dao;

/**
 * @author Marcos Santiago Leonardo
 * Universidad de la Sierra Sur (UNSIS)
 * Description: Queries for get groups
 * Date: 3/26/19
 */
final class QueriesGrupo {
    static final String QRY_COUNT_ITEM =
            "SELECT COUNT(1)\n" +
                    "FROM GRUPOS G, LICENCIATURAS L\n" +
                    "WHERE G.ID_LICENCIATURA = L.ID_LICENCIATURA AND L.ESTATUS = 'S' ";
    static final String QRY_GET_ALL =
            "SELECT G.*, L.NOMBRE_LICENCIATURA\n" +
                    "FROM GRUPOS G, LICENCIATURAS L\n" +
                    "WHERE G.ID_LICENCIATURA = L.ID_LICENCIATURA AND L.ESTATUS = 'S' ";
    static final String QRY_CONDITION_CVE_GRUPO = "\nAND G.CVE_GRUPO = ? ";
    static final String QRY_CONDITION_ESTATUS = "\nAND G.ESTATUS = ? ";
    static final String QRY_CONDITION_ID_GRUPO = "\nAND G.ID_GRUPO = ? ";
    static final String QRY_CONDITION_ID_LICENCIATURA = "\nAND G.ID_LICENCIATURA = ? ";
    static final String QRY_CONDITION_AGREGADO_POR = "\nAND G.AGREGADO_POR = ? ";
    static final String QRY_CONDITION_ACTUALIZADO_POR = "\nAND G.ACTUALIZADO_POR = ? ";
    static final String QRY_ADD =
            "INSERT INTO GRUPOS (CVE_GRUPO, ID_LICENCIATURA, ESTATUS, AGREGADO_POR, FECHA_CREACION)\n" +
                    "  VALUE (?, ?, ?, ?, NOW()) ";
    static final String QRY_UPDATE =
            "UPDATE GRUPOS SET CVE_GRUPO = ?, ID_LICENCIATURA = ?, ESTATUS = ?, ACTUALIZADO_POR = ?, FECHA_ACTUALIZACION = NOW() WHERE ID_GRUPO = ?";

    static final String QRY_ORDER_BY = "\nORDER BY L.NOMBRE_LICENCIATURA ASC, G.CVE_GRUPO ASC\n";
}
