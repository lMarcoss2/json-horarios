package edu.calc.becas.mconfiguracion.login.dao;

public class QueriesLogin {

  static final String QRY_GET_INFO_LOGIN ="SELECT ID_USUARIO,NOMBRES, APE_PATERNO, APE_MATERNO, ID_ROL, USERNAME FROM USUARIOS\n" +
    "WHERE USERNAME = ? \n" +
    "UNION\n" +
    "SELECT ID_ALUMNO,NOMBRES, APE_PATERNO, APE_MATERNO, '3', MATRICULA as USERNAME FROM ALUMNOS\n" +
    "WHERE MATRICULA = ? ";
}
