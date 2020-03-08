package edu.calc.json.horarios.common.base.dao;

/**
 * @author Marcos Santiago Leonardo
 * Universidad de la Sierra Sur (UNSIS)
 * Description:
 * Date: 3/26/19
 */
final class QueriesBaseDao {
    static final String QRY_PAGEABLE = "\nLIMIT %s OFFSET %s ";
    static final String QRY_COUNT_ITEM = "SELECT COUNT(1) FROM (%s) ABCDEF";
}
