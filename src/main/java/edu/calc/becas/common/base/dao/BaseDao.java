package edu.calc.becas.common.base.dao;


import static edu.calc.becas.common.base.dao.QueriesBaseDao.QRY_PAGEABLE;

/**
 * @author Marcos Santiago Leonardo
 * Universidad de la Sierra Sur (UNSIS)
 * Description: coomon methods for DAO
 * Date: 3/26/19
 */
public class BaseDao {
    protected String createQueryPageable(int page, int pageSize) {
        return String.format(QRY_PAGEABLE, pageSize, (page * pageSize));
    }
}
