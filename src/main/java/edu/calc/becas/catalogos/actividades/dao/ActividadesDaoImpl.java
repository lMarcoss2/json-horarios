package edu.calc.becas.catalogos.actividades.dao;

import edu.calc.becas.catalogos.actividades.model.ActividadesVo;
import edu.calc.becas.common.base.dao.BaseDao;
import edu.calc.becas.common.model.WrapperData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import static edu.calc.becas.catalogos.actividades.dao.QueriesActividades.QRY_ACTIVIDADES;
import static edu.calc.becas.catalogos.actividades.dao.QueriesActividades.QRY_COUNT_ITEM;

@Repository
public class ActividadesDaoImpl extends BaseDao implements ActividadesDao {

  private final JdbcTemplate jdbcTemplate;

  @Autowired
  public ActividadesDaoImpl(JdbcTemplate jdbcTemplate){
    this.jdbcTemplate=jdbcTemplate;
  }


  @Override
  public WrapperData getAll(int page, int pageSize) {
    int lengthDatatble = this.jdbcTemplate.queryForObject(QRY_COUNT_ITEM, Integer.class);
    List<ActividadesVo> data = this.jdbcTemplate.query(QRY_ACTIVIDADES, (rs, rowNum)-> mapperActividades(rs));
    return new WrapperData(data, page, pageSize, lengthDatatble);
  }

  private ActividadesVo mapperActividades(ResultSet rs) throws SQLException{
    ActividadesVo actividadesVo = new ActividadesVo(rs.getString("ESTATUS"));
    actividadesVo.setIdActividad(rs.getInt("ID_ACTIVIDAD"));
    actividadesVo.setNombreActividad(rs.getString("NOMBRE_ACTIVIDAD"));
    actividadesVo.setCicloEscolar(rs.getString("CICLO_ESCOLAR"));
    actividadesVo.setObligatorio(rs.getString("OBLIGATORIO"));
    actividadesVo.setNumeroAlumnos(rs.getInt("NUMERO_ALUMNOS"));
    return actividadesVo;
  }

}
