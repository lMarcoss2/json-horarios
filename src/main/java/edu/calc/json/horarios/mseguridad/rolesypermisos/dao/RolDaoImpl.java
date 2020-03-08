package edu.calc.json.horarios.mseguridad.rolesypermisos.dao;

import edu.calc.json.horarios.common.base.dao.BaseDao;
import edu.calc.json.horarios.common.model.WrapperData;
import edu.calc.json.horarios.mseguridad.rolesypermisos.model.Rol;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import static edu.calc.json.horarios.common.utils.Constant.ITEMS_FOR_PAGE;

/**
 * @author Marcos Santiago Leonardo
 * Universidad de la Sierra Sur (UNSIS)
 * Description:
 * Date: 4/14/19
 */
@Repository
public class RolDaoImpl extends BaseDao implements RolDao {

    private final String secretKeyStart = "4^%m@=C*&c#L+%";
    private final String secretKeyEnd = "U$|2AT>30!";

    public RolDaoImpl(JdbcTemplate jdbcTemplate) {
        super(jdbcTemplate);
    }

    @Override
    public WrapperData getAllByStatus(int page, int pageSize, String status) {
        boolean pageable = pageSize != Integer.parseInt(ITEMS_FOR_PAGE);

        String queryGetALl = addConditionFilterByStatus(status, QueriesRol.QRY_GET_ALL, QueriesRol.QRY_CONDITION_ESTATUS);

        queryGetALl = queryGetALl.concat(QueriesRol.QRY_ORDER_BY);

        queryGetALl = addQueryPageable(page, pageSize, queryGetALl);

        int lengthDataTable = this.jdbcTemplate.queryForObject(createQueryCountItem(queryGetALl), Integer.class);

        List<Rol> data = this.jdbcTemplate.query(queryGetALl, (rs, rowNum) -> mapperRol(rs));

        if (!pageable) {
            page = 0;
            pageSize = lengthDataTable;
        }
        return new WrapperData(data, page, pageSize, lengthDataTable);

    }

    @Override
    public WrapperData getAllByStatusAndOneParam(int page, int pageSize, String status, String tipoUsuario) {
        return null;
    }

    @Override
    public Rol add(Rol rol) {
        return null;
    }

    @Override
    public Rol update(Rol rol) {
        return null;
    }

    private Rol mapperRol(ResultSet rs) throws SQLException {
        Rol rol = new Rol(rs.getString("ESTATUS"));
        rol.setIdRol(rs.getInt("ID_ROL"));
        rol.setNombre(rs.getString("NOMBRE_ROL"));
        return rol;
    }
}
