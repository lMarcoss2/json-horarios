package edu.calc.becas.malumnos.actividades.dao;

import edu.calc.becas.common.base.dao.BaseDao;
import edu.calc.becas.mcatalogos.actividades.model.ActividadVo;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import static edu.calc.becas.malumnos.actividades.dao.QueriesActividadAlumno.QRY_GET_ACTIVIDAD_BY_ALUMNO;

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
    public ActividadVo getActividadByAlumno(String matricula) {
        return jdbcTemplate.queryForObject(
                QRY_GET_ACTIVIDAD_BY_ALUMNO,
                new Object[]{matricula},
                ((rs, i) -> mapperActividadAlumno(rs)));
    }

    private ActividadVo mapperActividadAlumno(ResultSet rs) throws SQLException {
        ActividadVo actividadVo = new ActividadVo(rs.getString("ESTATUS"));
        actividadVo.setIdActividad(rs.getInt("ID_ACTIVIDAD_ALUMNO"));
        actividadVo.setNombreActividad(rs.getString("NOMBRE_ACTIVIDAD"));
        return actividadVo;
    }
}
