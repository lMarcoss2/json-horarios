package edu.calc.becas.catalogos.licenciaturas.dao;

import edu.calc.becas.catalogos.licenciaturas.model.Licenciatura;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import static edu.calc.becas.catalogos.licenciaturas.dao.QueriesLicenciatura.GET_ALL;

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
    public List<Licenciatura> getAll() {
        return this.jdbcTemplate.query(GET_ALL, (rs, rowNum) -> mapperLicenciatura(rs));
    }

    private Licenciatura mapperLicenciatura(ResultSet rs) throws SQLException {
        Licenciatura lic = new Licenciatura(rs.getString("ESTATUS"));
        lic.setIdLicenciatura(rs.getInt("ID_LICENCIATURA"));
        lic.setCveLicenciatura(rs.getString("CVE_LICENCIATURA"));
        lic.setNombreLicenciatura(rs.getString("NOMBRE_LICENCIATURA"));
        return lic;
    }

}
