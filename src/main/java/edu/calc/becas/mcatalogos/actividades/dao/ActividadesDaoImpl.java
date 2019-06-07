package edu.calc.becas.mcatalogos.actividades.dao;

import edu.calc.becas.common.base.dao.BaseDao;
import edu.calc.becas.common.model.WrapperData;
import edu.calc.becas.mcatalogos.actividades.model.ActividadVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import static edu.calc.becas.common.utils.Constant.ESTATUS_DEFAULT;
import static edu.calc.becas.common.utils.Constant.ITEMS_FOR_PAGE;
import static edu.calc.becas.mcatalogos.actividades.dao.QueriesActividades.*;

@Repository
public class ActividadesDaoImpl extends BaseDao implements ActividadesDao {

  private final JdbcTemplate jdbcTemplate;

  @Autowired
  public ActividadesDaoImpl(JdbcTemplate jdbcTemplate){
    this.jdbcTemplate=jdbcTemplate;
  }


  @Override
  public WrapperData getAll(int page, int pageSize, String status) {

    boolean pageable = pageSize != Integer.parseInt(ITEMS_FOR_PAGE);
    boolean byStatus = !status.equalsIgnoreCase(ESTATUS_DEFAULT);


    String queryGetALl = QRY_GET_ALL;
    String queryCountItem = QRY_COUNT_ITEM;

    if (byStatus) {
      queryGetALl = queryGetALl.concat(QRY_CONDITION_ESTATUS.replace("?", "'" + status + "'"));
      queryCountItem = queryCountItem.concat(QRY_CONDITION_ESTATUS.replace("?", "'" + status + "'"));
    }

    if (pageable) {
      queryGetALl = queryGetALl.concat(createQueryPageable(page, pageSize));
    }

    int lengthDatatble = this.jdbcTemplate.queryForObject(QRY_COUNT_ITEM, Integer.class);
    List<ActividadVo> data = this.jdbcTemplate.query(QRY_ACTIVIDADES, (rs, rowNum)-> mapperActividades(rs));
    return new WrapperData(data, page, pageSize, lengthDatatble);
  }

  @Override
  public ActividadVo add(ActividadVo actividad) {
    this.jdbcTemplate.update(QRY_ADD, createObjectParamUpdate(actividad));
    return actividad;
  }

  private ActividadVo mapperActividades(ResultSet rs) throws SQLException{
    ActividadVo actividadVo = new ActividadVo(rs.getString("ESTATUS"));
    actividadVo.setIdActividad(rs.getInt("ID_ACTIVIDAD"));
    actividadVo.setNombreActividad(rs.getString("NOMBRE_ACTIVIDAD"));
    actividadVo.setCicloEscolar(rs.getString("CICLO_ESCOLAR"));
    actividadVo.setObligatorio(rs.getString("OBLIGATORIO"));
    actividadVo.setNumeroAlumnos(rs.getInt("NUMERO_ALUMNOS"));
    return actividadVo;
  }

  private Object[]createObjectParamUpdate(ActividadVo actividad){
    return new Object[]{};
  }

}
