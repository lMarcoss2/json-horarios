package edu.calc.becas.reporte.percent.beca.dao;

/**
 * @author Marcos Santiago Leonardo
 * Universidad de la Sierra Sur (UNSIS)
 * Description:
 * Date: 2019-06-16
 */
final class QueriesReportPercentBeca {
    static final String QRY_COUNT_ID_ACTIVIDAD_ALUMNO =
            "SELECT COUNT(1) FROM PORCENTAJE_BECA WHERE ID_ACTIVIDAD_ALUMNO = ?";
}
