package edu.calc.becas.catalogos.actividades.dao;

import edu.calc.becas.catalogos.actividades.model.ActividadesVo;
import edu.calc.becas.common.model.WrapperData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import static edu.calc.becas.catalogos.actividades.dao.QueriesActividades.QRY_ACTIVIDADES;
import static edu.calc.becas.catalogos.actividades.dao.QueriesActividades.QRY_COUNT_ITEM;

public class ActividadesDaoImpl implements ActividadesDao {

  private final JdbcTemplate jdbcTemplate;

  @Autowired
  public ActividadesDaoImpl(JdbcTemplate jdbcTemplate){
    this.jdbcTemplate=jdbcTemplate;
  }


  @Override
  public WrapperData getAll(int page, int pageSize) {
    int lengthDatatble = this.jdbcTemplate.queryForObject(QRY_COUNT_ITEM, Integer.class);
    List<ActividadesVo> data = this.jdbcTemplate.queryForObject(QRY_ACTIVIDADES, (rs, rowNum)-> mapperActividades(rs));


    return null;
  }

  private ActividadesVo mapperActividades(ResultSet rs) throws SQLException{
    ActividadesVo actividadesVo = new ActividadesVo(rs.getString("ESTATUS"));
    actividadesVo.setCicloEscolar(rs.getString(""));
    actividadesVo.setIdActividad(rs.getString(""));
    actividadesVo.set
    actividadesVo.setNumeroAlumnos(rs.getInt(""));
    actividadesVo.setObligatorio(rs.getString(""));

    return actividadesVo;
  }

}
