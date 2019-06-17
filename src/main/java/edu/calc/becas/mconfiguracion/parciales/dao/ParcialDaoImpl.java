package edu.calc.becas.mconfiguracion.parciales.dao;

import edu.calc.becas.common.base.dao.BaseDao;
import edu.calc.becas.mconfiguracion.parciales.model.Parcial;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * @author Marcos Santiago Leonardo
 * Universidad de la Sierra Sur (UNSIS)
 * Description:
 * Date: 4/9/19
 */
@Repository
public class ParcialDaoImpl extends BaseDao implements ParcialDao {
    public ParcialDaoImpl(JdbcTemplate jdbcTemplate) {
        super(jdbcTemplate);
    }

    @Override
    public List<Parcial> getAll() {
        return this.jdbcTemplate.query(QueriesParcial.QRY_GET_ALL, ((rs, i) -> mapperParcial(rs)));
    }

    private Parcial mapperParcial(ResultSet rs) throws SQLException {
        Parcial parcial = new Parcial();
        parcial.setIdParcial(rs.getInt("ID_PARCIAL"));
        parcial.setDescParcial(rs.getString("DESC_PARCIAL"));
        String parcialActual = rs.getString("PARCIAL_ACTUAL");
        parcial.setParcialActual(parcialActual.equalsIgnoreCase("S"));

        return parcial;
    }

    @Override
    public Parcial update(Parcial parcial) {
        this.jdbcTemplate.update(QueriesParcial.QRY_INACTIVE_ESTATUS, parcial.getIdParcial());
        this.jdbcTemplate.update(QueriesParcial.QRY_ACTIVE_ESTATUS, parcial.getIdParcial());
        parcial.setParcialActual(true);
        return parcial;
    }

    @Override
    public Parcial getParcialActual() {
        return this.jdbcTemplate.queryForObject(QueriesParcial.QRY_GET_PARCIAL_ACTUAL, ((rs, i) -> mapperParcial(rs)));
    }
}
