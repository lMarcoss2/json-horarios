package edu.calc.json.horarios.common.base.dao;


import edu.calc.json.horarios.common.utils.Constant;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

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

        boolean pageable = pageSize != Integer.parseInt(Constant.ITEMS_FOR_PAGE);
        if (pageable) {
            queryGetALl = queryGetALl.concat(getQueryPageable(page, pageSize));
        }

        return queryGetALl;
    }

    private String getQueryPageable(int page, int pageSize) {
        return String.format(QueriesBaseDao.QRY_PAGEABLE, pageSize, (page * pageSize));
    }

    protected String addConditionFilterByStatus(String status, String queryBase, String qryConditionStatus) {
        boolean byStatus = !status.equalsIgnoreCase(Constant.DEFAULT_ESTATUS);
        if (byStatus) {
            queryBase = queryBase.concat(qryConditionStatus.replace("?", "'" + status + "'"));
        }
        return queryBase;
    }

    protected String createQueryCountItem(String queryGetALl) {
        int startQryPageable = queryGetALl.indexOf("LIMIT");
        if (startQryPageable >= 0) {
            return String.format(QueriesBaseDao.QRY_COUNT_ITEM, queryGetALl.substring(0, startQryPageable));
        } else {
            return String.format(QueriesBaseDao.QRY_COUNT_ITEM, queryGetALl);
        }

    }
}
