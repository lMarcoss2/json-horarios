package edu.calc.becas.mconfiguracion.cicloescolar.dao;

import edu.calc.becas.common.base.dao.BaseDao;
import edu.calc.becas.common.model.LabelValueData;
import edu.calc.becas.common.model.WrapperData;
import edu.calc.becas.common.utils.Constant;
import edu.calc.becas.mconfiguracion.cicloescolar.model.CicloEscolarVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import static edu.calc.becas.common.model.LabelValueData.mapperLavelValue;
import static edu.calc.becas.mconfiguracion.cicloescolar.dao.QueriesCicloEscolar.*;

@Repository
public class CicloEscolarDaoImpl extends BaseDao implements CicloEscolarDao {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public CicloEscolarDaoImpl(JdbcTemplate jdbcTemplate){this.jdbcTemplate= jdbcTemplate;}

    @Override
    public WrapperData getAll(int page, int pageSize) {
        int lengthDatatable = this.jdbcTemplate.queryForObject(QRY_COUNT_CICLO_ESCOLAR, Integer.class);
        List<CicloEscolarVo> data = this.jdbcTemplate.query(QRY_CICLO_ESCOLAR, (rs, rowNum)-> mapperCicloEscolar(rs));
        return new WrapperData(data, page, pageSize, lengthDatatable);
    }

    public List<LabelValueData> getListCatalog(){

        return this.jdbcTemplate.query(QRY_LIST_CICLO, (rs, rowNum)-> mapperLavelValue(rs));
    }


    @Override
    public CicloEscolarVo add(CicloEscolarVo ciclo) {
        this.jdbcTemplate.update(QRY_ADD, createObjectParam(ciclo));
        return ciclo;
    }

    private Object[] createObjectParam(CicloEscolarVo ciclo) {
        return new Object[]{ciclo.getDescripcionCiclo(), ciclo.getEstatus()};
    }

    private CicloEscolarVo mapperCicloEscolar(ResultSet rs) throws SQLException{
        CicloEscolarVo cicloEscolarVo = new CicloEscolarVo (rs.getString("ESTATUS"));

        cicloEscolarVo.setIdCicloEscolar(rs.getInt("ID_CICLO_ESCOLAR"));
        cicloEscolarVo.setDescripcionCiclo(rs.getString("DESCRIPCION_CICLO"));
        cicloEscolarVo.setPeriodoActual(valueActivo(rs.getString("PERIODO_ACTUAL")));
        return cicloEscolarVo;
    }

    public String valueActivo(String estatus) {
        if (estatus.equals(Constant.ESTATUS_ACTIVE)) {
            return "SI";
        }
        return "No";
    }
}
