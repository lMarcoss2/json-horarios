package edu.calc.becas.common.base.dao;


import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import static edu.calc.becas.common.base.dao.QueriesBaseDao.QRY_PAGEABLE;
import static edu.calc.becas.common.utils.Constant.ESTATUS_DEFAULT;
import static edu.calc.becas.common.utils.Constant.ITEMS_FOR_PAGE;

/**
 * @author Marcos Santiago Leonardo
 * Universidad de la Sierra Sur (UNSIS)
 * Description: coomon methods for DAO
 * Date: 3/26/19
 */
@Component
public class BaseDao {
    protected final JdbcTemplate jdbcTemplate;

    public BaseDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    protected String addQueryPageable(int page, int pageSize, String queryGetALl) {

        boolean pageable = pageSize != Integer.parseInt(ITEMS_FOR_PAGE);
        if (pageable) {
            queryGetALl = queryGetALl.concat(getQueryPageable(page, pageSize));
        }

        return queryGetALl;
    }

    private String getQueryPageable(int page, int pageSize) {
        return String.format(QRY_PAGEABLE, pageSize, (page * pageSize));
    }

    protected String addConditionFilterByStatus(String status, String queryBase, String qryConditionStatus) {
        boolean byStatus = !status.equalsIgnoreCase(ESTATUS_DEFAULT);
        if (byStatus) {
            queryBase = queryBase.concat(qryConditionStatus.replace("?", "'" + status + "'"));
        }
        return queryBase;
    }
}
