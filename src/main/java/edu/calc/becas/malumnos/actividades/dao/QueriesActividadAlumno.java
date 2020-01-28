package edu.calc.becas.malumnos.actividades.dao;

/**
 * @author Marcos Santiago Leonardo
 * Universidad de la Sierra Sur (UNSIS)
 * Description:
 * Date: 2019-06-16
 */
final class QueriesActividadAlumno {
    static final String QRY_GET_ACTIVIDAD_BY_ALUMNO =
            "SELECT AL.ID_ACTIVIDAD_ALUMNO, A.NOMBRE_ACTIVIDAD, A.ESTATUS\n" +
                    "FROM CICLO_ESCOLAR C, HORARIO_ACTIVIDAD H, ACTIVIDADES A, ACTIVIDAD_ALUMNO AL, ALUMNOS ALU\n" +
                    "WHERE C.PERIODO_ACTUAL = 'S'\n" +
                    "  AND H.ESTATUS = 'S'\n" +
                    "  AND C.ESTATUS = 'S'\n" +
                    "  AND A.ESTATUS = 'S'\n" +
                    "  AND ALU.ESTATUS = 'S'\n" +
                    "  AND C.ID_CICLO_ESCOLAR = H.ID_CICLO_ESCOLAR\n" +
                    "  AND H.ID_ACTIVIDAD = A.ID_ACTIVIDAD\n" +
                    "  AND H.ID_HORARIO_ACTIVIDAD = AL.ID_ACTIVIDAD\n" +
                    "  AND ALU.ID_ALUMNO = AL.ID_ALUMNO\n" +
                    "  AND ALU.MATRICULA = ?";

    static final String QRY_GET_ALL_ACTIVIDADES_ALUMNOS = "SELECT ACT.ID_ACTIVIDAD, AL.ID_ALUMNO, ACT.NOMBRE_ACTIVIDAD, AL.MATRICULA, AL.NOMBRES, AL.APE_PATERNO, AL.APE_MATERNO\n" +
      "FROM ACTIVIDAD_ALUMNO AC\n" +
      "  INNER JOIN ALUMNOS AL\n" +
      "  ON AC.MATRICULA = AL.MATRICULA\n" +
      "  INNER JOIN ACTIVIDADES ACT\n" +
      "ON AC.ID_ACTIVIDAD =  ACT.ID_ACTIVIDAD";
}
