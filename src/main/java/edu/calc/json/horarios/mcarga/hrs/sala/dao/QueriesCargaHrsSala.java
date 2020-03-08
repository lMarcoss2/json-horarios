package edu.calc.json.horarios.mcarga.hrs.sala.dao;

/**
 * @author Marcos Santiago Leonardo
 * Universidad de la Sierra Sur (UNSIS)
 * Description:
 * Date: 2019-06-16
 */
final class QueriesCargaHrsSala {
    static final String QRY_INSERT_PERCENT_SALA =
            "INSERT INTO PORCENTAJE_BECA (ID_ACTIVIDAD_ALUMNO, PORCENTAJE_SALA, ID_PARCIAL, AGREGADO_POR, FECHA_CREACION) " +
                    "VALUE (?, ?, ?, ?, NOW())";

    static final String QRY_UPDATE_PERCENT_SALA =
            "UPDATE PORCENTAJE_BECA SET PORCENTAJE_SALA = ? WHERE ID_ACTIVIDAD_ALUMNO = ? AND ID_PARCIAL = ?";
}
