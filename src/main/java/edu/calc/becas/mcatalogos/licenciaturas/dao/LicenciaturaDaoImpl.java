package edu.calc.becas.mcatalogos.licenciaturas.dao;

import edu.calc.becas.common.base.dao.BaseDao;
import edu.calc.becas.common.model.WrapperData;
import edu.calc.becas.mcatalogos.licenciaturas.model.Licenciatura;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static edu.calc.becas.common.utils.Constant.ESTATUS_DEFAULT;
import static edu.calc.becas.common.utils.Constant.ITEMS_FOR_PAGE;
import static edu.calc.becas.mcatalogos.licenciaturas.dao.QueriesLicenciatura.*;

/**
 * @author Marcos Santiago Leonardo
 * Universidad de la Sierra Sur (UNSIS)
 * Description: implements dao for the Licenciatura service
 * Date: 3/23/19
 */
@Repository
public class LicenciaturaDaoImpl extends BaseDao implements LicenciaturaDao {

    public LicenciaturaDaoImpl(JdbcTemplate jdbcTemplate) {
        super(jdbcTemplate);
    }

    @Override
    public WrapperData getAll(int page, int pageSize, String status) {

        boolean pageable = pageSize != Integer.parseInt(ITEMS_FOR_PAGE);


        String queryGetALl = addConditionFilterByStatus(status, QRY_GET_ALL, QRY_CONDITION_ESTATUS);
        String queryCountItem = addConditionFilterByStatus(status, QRY_COUNT_ITEM, QRY_CONDITION_ESTATUS);

        queryGetALl = queryGetALl.concat(QRY_ORDER_BY_NOMBRE_LICENCIATURA);


        queryGetALl = addQueryPageable(page, pageSize, queryGetALl);


        int lengthDataTable = this.jdbcTemplate.queryForObject(queryCountItem, Integer.class);

        List<Licenciatura> data = this.jdbcTemplate.query(queryGetALl, (rs, rowNum) -> mapperLicenciatura(rs));

        if (!pageable) {
            page = 0;
            pageSize = lengthDataTable;
        }
        return new WrapperData(data, page, pageSize, lengthDataTable);
    }

    @Override
    public Licenciatura add(Licenciatura lic) {
        this.jdbcTemplate.update(QRY_ADD, createObjectParam(lic));
        return lic;
    }

    @Override
    public Licenciatura update(Licenciatura lic) {
        this.jdbcTemplate.update(QRY_UPDATE, createObjectParamUpdate(lic));
        return lic;
    }

    private Licenciatura getByAllAttributes(Licenciatura lic) {
        String query = QRY_GET_BY_CUSTOM_PARAM;
        List params = new ArrayList();
        if (lic.getIdLicenciatura() > 0) {
            query = query.concat(QRY_CONDITION_ID_LICENCIATURA);
            params.add(lic.getIdLicenciatura());
        }
        if (lic.getCveLicenciatura() != null) {
            query = query.concat(QRY_CONDITION_CVE_LICENCIATURA);
            params.add(lic.getCveLicenciatura());
        }

        if (lic.getNombreLicenciatura() != null) {
            query = query.concat(QRY_CONDITION_NOMBRE_LICENCIATURA);
            params.add(lic.getNombreLicenciatura());
        }

        if (lic.getEstatus() != null) {
            query = query.concat(QRY_CONDITION_ESTATUS);
            params.add(lic.getEstatus());
        }

        if (lic.getAgregadoPor() != null) {
            query = query.concat(QRY_CONDITION_AGREGADO_POR);
            params.add(lic.getAgregadoPor());
        }

        if (lic.getActualizadoPor() != null) {
            query = query.concat(QRY_CONDITION_ACTUALIZADO_POR);
            params.add(lic.getActualizadoPor());
        }


        return this.jdbcTemplate.queryForObject(query, params.toArray(), ((rs, rowNum) -> mapperLicenciatura(rs)));
    }

    private Object[] createObjectParam(Licenciatura lic) {
        return new Object[]{lic.getCveLicenciatura(), lic.getNombreLicenciatura(), lic.getEstatus(), lic.getAgregadoPor()};
    }

    private Object[] createObjectParamUpdate(Licenciatura lic) {
        return new Object[]{lic.getCveLicenciatura(), lic.getNombreLicenciatura(), lic.getEstatus(), lic.getActualizadoPor(), lic.getIdLicenciatura()};
    }

    private Licenciatura mapperLicenciatura(ResultSet rs) throws SQLException {
        Licenciatura lic = new Licenciatura(rs.getString("ESTATUS"));
        lic.setIdLicenciatura(rs.getInt("ID_LICENCIATURA"));
        lic.setCveLicenciatura(rs.getString("CVE_LICENCIATURA"));
        lic.setNombreLicenciatura(rs.getString("NOMBRE_LICENCIATURA"));
        return lic;
    }

}
