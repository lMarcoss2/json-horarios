package edu.calc.becas.malumnos.dao;

import edu.calc.becas.common.base.dao.BaseDao;
import edu.calc.becas.common.model.WrapperData;
import edu.calc.becas.malumnos.model.Alumno;
import edu.calc.becas.mcatalogos.actividades.model.ActividadVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import static edu.calc.becas.common.utils.Constant.ESTATUS_DEFAULT;
import static edu.calc.becas.common.utils.Constant.ITEMS_FOR_PAGE;
import static edu.calc.becas.malumnos.dao.QueriesAlumnos.*;


@Repository
public class AlumnosDaoImpl extends BaseDao implements AlumnosDao {


    public AlumnosDaoImpl(JdbcTemplate jdbcTemplate) {
        super(jdbcTemplate);
    }

    @Override
    public WrapperData getAll(int page, int pageSize, String status, String idActividad) {
        boolean pageable = pageSize != Integer.parseInt(ITEMS_FOR_PAGE);
        boolean byStatus = !status.equalsIgnoreCase(ESTATUS_DEFAULT);
        boolean byActivity = !idActividad.equalsIgnoreCase(ESTATUS_DEFAULT);

        String queryCountItem = QRY_COUNT_ITEM;
        String queryGetALl = QRY_GET_ALL;

        if (byStatus) {
            queryGetALl = queryGetALl.concat(QRY_CONDITION_ESTATUS.replace("?", "'" + status + "'"));
            queryCountItem = queryCountItem.concat(QRY_CONDITION_ESTATUS.replace("?", "'" + status + "'"));
        }

        if(byActivity){
            queryGetALl = queryGetALl.concat(QRY_CONDITION_ACTIVIDAD.replace("?", "'" + idActividad + "'"));
            //queryCountItem = queryCountItem.concat(QRY_CONDITION_ACTIVIDAD.replace("?", "'" + idActividad + "'"));
        }


        queryGetALl = queryGetALl.concat(QRY_ORDER_BY_NOMBRE_ALUMNO);

        if (pageable) {
            queryGetALl = queryGetALl.concat(createQueryPageable(page, pageSize));
        }

        int lengthDataTable = this.jdbcTemplate.queryForObject(queryCountItem, Integer.class);

        List<Alumno > data = this.jdbcTemplate.query(queryGetALl, (rs, rowNum) -> mapperAlumno(rs));

        if (!pageable) {
            page = 0;
            pageSize = lengthDataTable;
        }
        return new WrapperData(data, page, pageSize, lengthDataTable);

    }

        private Alumno mapperAlumno(ResultSet rs) throws SQLException {
        Alumno alumno = new Alumno(rs.getString("ESTATUS"));
        ActividadVo actividadVo = new ActividadVo();
            alumno.setIdAlumno(rs.getString("ID_ALUMNO"));
            alumno.setMatricula(rs.getString("MATRICULA"));
            alumno.setNombres(rs.getString("NOMBRES"));
            alumno.setApePaterno(rs.getString("APE_PATERNO"));
            alumno.setApeMaterno(rs.getString("APE_MATERNO"));
            actividadVo.setIdActividad(rs.getInt("ID_ACTIVIDAD"));
            actividadVo.setNombreActividad(rs.getString("NOMBRE_ACTIVIDAD"));
            alumno.setActividad(actividadVo);
            return alumno;
        }


    }
