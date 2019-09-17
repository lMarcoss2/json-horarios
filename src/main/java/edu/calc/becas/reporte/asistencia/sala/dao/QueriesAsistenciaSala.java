package edu.calc.becas.reporte.asistencia.sala.dao;

final class QueriesAsistenciaSala {
    private QueriesAsistenciaSala() {
    }

    static final String GET_ALUMNOS_BY_USER_AND_SCHEDULE = "SELECT HA.ID_HORARIO_ACTIVIDAD,AA.ID_ACTIVIDAD_ALUMNO, A.NOMBRES, A.APE_PATERNO, A.APE_MATERNO\n" +
            "FROM USUARIOS US, HORARIO_ACTIVIDAD HA, ACTIVIDAD_ALUMNO AA, ALUMNOS_DAT_PERIODO ADP, ALUMNOS A\n" +
            "WHERE US.USERNAME = ?\n" +
            "  AND HA.ID_ACTIVIDAD = 2\n" +
            "  AND HA.ID_HORARIO_ACTIVIDAD = ?\n" +
            "  AND US.ID_USUARIO = HA.ID_USUARIO\n" +
            "    AND HA.ID_HORARIO_ACTIVIDAD = AA.ID_ACTIVIDAD\n" +
            "    AND AA.ID_ALUMNO = ADP.ID_ALUMNO\n" +
            "    AND ADP.ID_ALUMNO = A.ID_ALUMNO";

}
