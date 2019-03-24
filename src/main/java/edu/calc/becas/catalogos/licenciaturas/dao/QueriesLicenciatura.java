package edu.calc.becas.catalogos.licenciaturas.dao;

/**
 * @author Marcos Santiago Leonardo
 * Universidad de la Sierra Sur (UNSIS)
 * Description: define queries for majors
 * Date: 3/23/19
 */
final class QueriesLicenciatura {
    public static final String QRY_COUNT_ITEM = "SELECT COUNT(1) FROM LICENCIATURAS";
    public static final String QRY_GET_ALL = "SELECT * FROM LICENCIATURAS";
    public static final String QRY_PAGEABLE = " LIMIT %s OFFSET %s ";
}
