package edu.calc.json.horarios.mconfiguracion.parciales.dao;

import edu.calc.json.horarios.common.base.dao.BaseDao;
import edu.calc.json.horarios.common.model.WrapperData;
import edu.calc.json.horarios.mconfiguracion.parciales.model.Parcial;
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
    public List<Parcial> getAllByPeriodo(String cvePeriodo) {
        return this.jdbcTemplate.query(QueriesParcial.QRY_GET_ALL, new Object[]{cvePeriodo}, ((rs, i) -> mapperParcial(rs)));
    }

    @Override
    public Parcial getParcialActual() {
        return this.jdbcTemplate.queryForObject(QueriesParcial.QRY_GET_PARCIAL_ACTUAL, ((rs, i) -> mapperParcial(rs)));
    }

    private Parcial mapperParcial(ResultSet rs) throws SQLException {
        Parcial parcial = new Parcial();
        parcial.setIdParcial(rs.getInt("ID_PARCIAL"));
        parcial.setParcial(rs.getInt("PARCIAL"));
        parcial.setDescParcial(rs.getString("DESC_PARCIAL"));
        parcial.setParcialActual(rs.getString("PARCIAL_ACTUAL"));
        parcial.setFechaInicio(rs.getString("FECHA_INICIO"));
        parcial.setFechaFin(rs.getString("FECHA_FIN"));
        parcial.setCvePeriodo(rs.getString("CVE_PERIODO"));
        parcial.setDescPeriodo(rs.getString("DESC_PERIODO"));
        parcial.setTotalHorasBiblioteca(rs.getInt("TOTAL_HORAS_BIBLIOTECA"));
        parcial.setTotalAsistenciaSala(rs.getInt("TOTAL_ASISTENCIA_SALA"));

        return parcial;
    }

    @Override
    public WrapperData getAllByStatus(int page, int pageSize, String status) {
        return null;
    }

    @Override
    public WrapperData getAllByStatusAndOneParam(int page, int pageSize, String status, String param1) {
        return null;
    }

    @Override
    public Parcial add(Parcial p) {
        validateStatus(p);
        jdbcTemplate.update(QueriesParcial.QRY_ADD,
                p.getParcial(), p.getParcialActual(), p.getFechaInicio(), p.getFechaFin(),
                p.getCvePeriodo(), p.getDescPeriodo(), p.getAgregadoPor(), p.getTotalHorasBiblioteca(),p.getTotalAsistenciaSala());
        return p;
    }

    private void validateStatus(Parcial p) {
        if(p.getParcialActual().equalsIgnoreCase("S")){
            jdbcTemplate.update(QueriesParcial.QRY_INACTIVE_ESTATUS);
        }
    }

    @Override
    public Parcial update(Parcial p) {
        validateStatus(p);
        jdbcTemplate.update(QueriesParcial.QRY_UPDATE,
                p.getParcial(), p.getParcialActual(), p.getFechaInicio(), p.getFechaFin(),
                p.getCvePeriodo(), p.getDescPeriodo(), p.getActualizadoPor(),p.getTotalHorasBiblioteca(),p.getTotalAsistenciaSala(), p.getIdParcial());
        return p;
    }
}
