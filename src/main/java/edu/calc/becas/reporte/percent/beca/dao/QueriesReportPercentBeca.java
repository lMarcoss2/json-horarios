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

    static final String QRY_COUNT_DATA_REPORT =
            "SELECT COUNT(1) \n";

    static final String QRY_SELECT_DATA_REPORT =
            "SELECT P.ID_PORCENTAJE_BECA,\n" +
                    "       A.ID_ALUMNO,\n" +
                    "       A.MATRICULA,\n" +
                    "       A.NOMBRES,\n" +
                    "       A.APE_PATERNO,\n" +
                    "       A.APE_MATERNO,\n" +
                    "       P.ID_ACTIVIDAD_ALUMNO,\n" +
                    "       P.PORCENTAJE_SALA,\n" +
                    "       P.PORCENTAJE_BIBLIOTECA,\n" +
                    "       P.PORCENTAJE_ACTIVIDAD,\n" +
                    "       AC.ID_ACTIVIDAD,\n" +
                    "       AC.NOMBRE_ACTIVIDAD,\n" +
                    "       P.ID_PARCIAL,\n" +
                    "       PA.DESC_PARCIAL,\n" +
                    "       CE.ID_CICLO_ESCOLAR,\n" +
                    "       CE.DESCRIPCION_CICLO,\n" +
                    "       AL.ID_GRUPO,\n" +
                    "       G.CVE_GRUPO,\n" +
                    "       L.ID_LICENCIATURA,\n" +
                    "       L.CVE_LICENCIATURA,\n" +
                    "       L.NOMBRE_LICENCIATURA\n";

    static final String QRY_ORDER_BY = "\nORDER BY A.NOMBRES ASC, A.APE_PATERNO ASC, A.APE_MATERNO ASC, G.CVE_GRUPO ASC, L.NOMBRE_LICENCIATURA ASC";

    static final String QRY_FROM_DATA_REPORTE_ACTIVIDADES =
            "FROM PORCENTAJE_BECA P,\n" +
                    "     PARCIALES PA,\n" +
                    "     ACTIVIDAD_ALUMNO AL,\n" +
                    "     HORARIO_ACTIVIDAD H,\n" +
                    "     CICLO_ESCOLAR CE,\n" +
                    "     ACTIVIDADES AC,\n" +
                    "     ALUMNOS A,\n" +
                    "     GRUPOS G,\n" +
                    "     LICENCIATURAS L\n" +
                    "WHERE P.ID_PARCIAL = PA.ID_PARCIAL\n" +
                    "  AND P.ID_ACTIVIDAD_ALUMNO = AL.ID_ACTIVIDAD_ALUMNO\n" +
                    "  AND H.ESTATUS = 'S'\n" +
                    "  AND AL.ID_ACTIVIDAD = H.ID_HORARIO_ACTIVIDAD\n" +
                    "  AND CE.ESTATUS = 'S'\n" +
                    "  AND H.ID_CICLO_ESCOLAR = CE.ID_CICLO_ESCOLAR\n" +
                    "  AND AC.ESTATUS = 'S'\n" +
                    "  AND H.ID_ACTIVIDAD = AC.ID_ACTIVIDAD\n" +
                    "  AND A.ESTATUS = 'S'\n" +
                    "  AND AL.ID_ALUMNO = A.ID_ALUMNO\n" +
                    "  AND G.ESTATUS = 'S'\n" +
                    "  AND AL.ID_GRUPO = G.ID_GRUPO\n" +
                    "  AND L.ESTATUS = 'S'\n" +
                    "  AND G.ID_LICENCIATURA = L.ID_LICENCIATURA\n";


}
