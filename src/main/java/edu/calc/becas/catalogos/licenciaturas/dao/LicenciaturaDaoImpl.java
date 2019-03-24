package edu.calc.becas.catalogos.licenciaturas.dao;

import edu.calc.becas.catalogos.licenciaturas.model.Licenciatura;
import edu.calc.becas.common.model.WrapperData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import static edu.calc.becas.catalogos.licenciaturas.dao.QueriesLicenciatura.QRY_COUNT_ITEM;
import static edu.calc.becas.catalogos.licenciaturas.dao.QueriesLicenciatura.QRY_GET_ALL;
import static edu.calc.becas.catalogos.licenciaturas.dao.QueriesLicenciatura.QRY_PAGEABLE;

/**
 * @author Marcos Santiago Leonardo
 * Universidad de la Sierra Sur (UNSIS)
 * Description: implements dao for the major service
 * Date: 3/23/19
 */
@Repository
public class LicenciaturaDaoImpl implements LicenciaturaDao {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public LicenciaturaDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public WrapperData getAll(int page, int pageSize) {
        int lengthDataTable = this.jdbcTemplate.queryForObject(QRY_COUNT_ITEM, Integer.class);
        List<Licenciatura> data = this.jdbcTemplate.query(QRY_GET_ALL.concat(createQueryPageable(page, pageSize)), (rs, rowNum) -> mapperLicenciatura(rs));
        return new WrapperData(data, page, pageSize, lengthDataTable);
    }

    private String createQueryPageable(int page, int pageSize) {
        return String.format(QRY_PAGEABLE, pageSize, (page * pageSize));
    }

    private Licenciatura mapperLicenciatura(ResultSet rs) throws SQLException {
        Licenciatura lic = new Licenciatura(rs.getString("ESTATUS"));
        lic.setIdLicenciatura(rs.getInt("ID_LICENCIATURA"));
        lic.setCveLicenciatura(rs.getString("CVE_LICENCIATURA"));
        lic.setNombreLicenciatura(rs.getString("NOMBRE_LICENCIATURA"));
        return lic;
    }

}
