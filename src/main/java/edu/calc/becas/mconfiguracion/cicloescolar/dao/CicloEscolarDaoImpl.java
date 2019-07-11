package edu.calc.becas.mconfiguracion.cicloescolar.dao;

import edu.calc.becas.common.base.dao.BaseDao;
import edu.calc.becas.common.model.LabelValueData;
import edu.calc.becas.common.model.WrapperData;
import edu.calc.becas.common.utils.Constant;
import edu.calc.becas.mconfiguracion.cicloescolar.model.CicloEscolarVo;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import static edu.calc.becas.common.model.LabelValueData.mapperLavelValue;
import static edu.calc.becas.mconfiguracion.cicloescolar.dao.QueriesCicloEscolar.*;

@Repository
public class CicloEscolarDaoImpl extends BaseDao implements CicloEscolarDao {

    public CicloEscolarDaoImpl(JdbcTemplate jdbcTemplate) {
        super(jdbcTemplate);
    }

    @Override
    public WrapperData getAllByStatus(int page, int pageSize, String status) {
        int lengthDatatable = this.jdbcTemplate.queryForObject(createQueryCountItem(QRY_CICLO_ESCOLAR), Integer.class);
        List<CicloEscolarVo> data = this.jdbcTemplate.query(QRY_CICLO_ESCOLAR, (rs, rowNum) -> mapperCicloEscolar(rs));
        return new WrapperData(data, page, pageSize, lengthDatatable);
    }

    @Override
    public WrapperData getAllByStatusAndOneParam(int page, int pageSize, String status, String param1) {
        return null;
    }

    public List<LabelValueData> getListCatalog() {

        return this.jdbcTemplate.query(QRY_LIST_CICLO, (rs, rowNum) -> mapperLavelValue(rs));
    }


    @Override
    public CicloEscolarVo add(CicloEscolarVo ciclo) {
        if(ciclo.getPeriodoActual().equals("S")){
            this.jdbcTemplate.update(QRY_UPDATE_STATUS);
        }
        this.jdbcTemplate.update(QRY_ADD, createObjectParam(ciclo));
        return ciclo;
    }

    @Override
    public CicloEscolarVo update(CicloEscolarVo object) {
        if(object.getPeriodoActual().equals("S")){
            this.jdbcTemplate.update(QRY_UPDATE_STATUS);
        }
        this.jdbcTemplate.update(QRY_UPDATE, new Object[]{
                object.getDescripcionCiclo(),
                object.getPeriodoActual(),
                object.getIdCicloEscolar()
        });
        return object;
    }

    private Object[] createObjectParam(CicloEscolarVo ciclo) {
        return new Object[]{ciclo.getDescripcionCiclo(), "S"};
    }

    private CicloEscolarVo mapperCicloEscolar(ResultSet rs) throws SQLException {
        CicloEscolarVo cicloEscolarVo = new CicloEscolarVo(rs.getString("ESTATUS"));

        cicloEscolarVo.setIdCicloEscolar(rs.getInt("ID_CICLO_ESCOLAR"));
        cicloEscolarVo.setDescripcionCiclo(rs.getString("DESCRIPCION_CICLO"));
        cicloEscolarVo.setPeriodoActual(rs.getString("PERIODO_ACTUAL"));
        cicloEscolarVo.setDesPeriodoActual(valueActivo(rs.getString("PERIODO_ACTUAL")));
        return cicloEscolarVo;
    }

    public String valueActivo(String estatus) {
        if (estatus.equals(Constant.ESTATUS_ACTIVE)) {
            return "SI";
        }
        return "No";
    }
}
