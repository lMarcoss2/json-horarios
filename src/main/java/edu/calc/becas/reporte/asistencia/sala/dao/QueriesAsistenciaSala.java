package edu.calc.becas.reporte.asistencia.sala.dao;

final class QueriesAsistenciaSala {
    private QueriesAsistenciaSala() {
    }

    static final String GET_ALUMNOS_BY_USER_AND_SCHEDULE = "SELECT U.DIAS_RETROCESO_REPORTE, AA.ID_ACTIVIDAD_ALUMNO, U.ID_USUARIO, A.MATRICULA, A.NOMBRES,  A.APE_PATERNO, A.APE_MATERNO, HA.ID_HORARIO_ACTIVIDAD\n" +
            "FROM USUARIOS U, HORARIO_ACTIVIDAD HA, ACTIVIDAD_ALUMNO AA, ALUMNOS_DAT_PERIODO AP, ALUMNOS A\n" +
            "WHERE U.USERNAME = ? AND U.ESTATUS = 'S'\n" +
            "  AND U.ID_USUARIO = HA.ID_USUARIO\n" +
            "  AND HA.ID_HORARIO_ACTIVIDAD = ?\n" +
            "  AND HA.ID_HORARIO_ACTIVIDAD = AA.ID_HORARIO_ACTIVIDAD\n" +
            "  AND HA.ID_ACTIVIDAD = 2\n" +
            "  AND HA.ESTATUS = 'S'\n" +
            "  AND AA.ID_ALUMNO_P = AP.ID_ALUMNOP\n" +
            "  AND AP.MATRICULA = A.MATRICULA\n";


    static final String QRY_GET_ASISTENCIA_BY_ACTIVIDAD_ALUMNO = "SELECT ASISTENCIA FROM ASISTENCIA_SALA WHERE  ID_ACTIVIDAD_ALUMNO = ? AND FECHA_ASISTENCIA = ?\n";

}
