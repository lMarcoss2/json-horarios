package edu.calc.json.horarios.malumnos.actividades.dao;

import edu.calc.json.horarios.common.base.dao.BaseDao;
import edu.calc.json.horarios.common.model.WrapperData;
import edu.calc.json.horarios.malumnos.actividades.model.ActividadesAlumnos;
import edu.calc.json.horarios.mcatalogos.actividades.model.ActividadVo;
import edu.calc.json.horarios.mconfiguracion.cicloescolar.model.CicloEscolarVo;
import edu.calc.json.horarios.common.utils.Constant;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * @author Marcos Santiago Leonardo
 * Universidad de la Sierra Sur (UNSIS)
 * Description: consulta de actividades por alumno(s)
 * Date: 2019-06-16
 */
@Repository
public class AlumnoActividadDaoImpl extends BaseDao implements AlumnoActividadDao {

    public AlumnoActividadDaoImpl(JdbcTemplate jdbcTemplate) {
        super(jdbcTemplate);
    }

    @Override
    public ActividadVo getActividadByAlumno(String matricula, CicloEscolarVo cicloEscolarActual) {
        return jdbcTemplate.queryForObject(
                QueriesActividadAlumno.QRY_GET_ACTIVIDAD_BY_ALUMNO,
                new Object[]{matricula, cicloEscolarActual.getClave()},
                ((rs, i) -> mapperActividadAlumnoPorMatriculaYCvePeriodo(rs)));
    }

    private ActividadVo mapperActividadAlumnoPorMatriculaYCvePeriodo(ResultSet rs) throws SQLException {
        ActividadVo actividadVo = new ActividadVo(Constant.ESTATUS_ACTIVE);
        actividadVo.setIdActividad(rs.getInt("ID_ACTIVIDAD_ALUMNO"));
        return actividadVo;
    }

    @Override
    public WrapperData getAllAlumnosByActividad(int page, int pageSize, String idActividad, String idCiclo){
      boolean pageable = pageSize != Integer.parseInt(Constant.ITEMS_FOR_PAGE);
      String queryGetAll = QueriesActividadAlumno.QRY_GET_ALL_ACTIVIDADES_ALUMNOS;

      queryGetAll = addQueryPageable(page, pageSize, queryGetAll);

      int lengthDatable = this.jdbcTemplate.queryForObject(createQueryCountItem(queryGetAll), Integer.class);

      List<ActividadesAlumnos> data = this.jdbcTemplate.query(queryGetAll, (rs, rowNum) -> mapperActividadesAlumnos(rs));

      if (!pageable) {
        page = 0;
        pageSize = lengthDatable;
      }

      return new WrapperData(data, page, pageSize, lengthDatable);
    }

    private ActividadVo mapperActividadAlumno(ResultSet rs) throws SQLException {
        ActividadVo actividadVo = new ActividadVo(rs.getString("ESTATUS"));
        actividadVo.setIdActividad(rs.getInt("ID_ACTIVIDAD_ALUMNO"));
        actividadVo.setNombreActividad(rs.getString("NOMBRE_ACTIVIDAD"));
        return actividadVo;
    }
/*ACT.ID_ACTIVIDAD, ACT.NOMBRE_ACTIVIDAD, AL.ID_ALUMNO, AL.MATRICULA, AL.NOMBRES, AL.APE_PATERNO, AL.APE_MATERNO*/
    private ActividadesAlumnos mapperActividadesAlumnos(ResultSet rs) throws SQLException {
        ActividadesAlumnos actividadVo = new ActividadesAlumnos();
        actividadVo.setIdActividad(rs.getInt("ID_ACTIVIDAD"));
        actividadVo.setNombreActividad(rs.getString("NOMBRE_ACTIVIDAD"));
        actividadVo.setIdAlumno(rs.getString("ID_ALUMNO_P"));
        actividadVo.setMatricula(rs.getString("MATRICULA"));
        actividadVo.setNombre(rs.getString("NOMBRES"));
        actividadVo.setAPaterno(rs.getString("APE_PATERNO"));
        actividadVo.setAMaterno(rs.getString("APE_MATERNO"));
        return actividadVo;
    }
}
