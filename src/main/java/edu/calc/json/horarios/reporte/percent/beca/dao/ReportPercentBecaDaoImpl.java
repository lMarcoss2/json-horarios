package edu.calc.json.horarios.reporte.percent.beca.dao;

import edu.calc.json.horarios.common.base.dao.BaseDao;
import edu.calc.json.horarios.common.model.Pageable;
import edu.calc.json.horarios.common.model.WrapperData;
import edu.calc.json.horarios.mcatalogos.actividades.model.ActividadVo;
import edu.calc.json.horarios.reporte.percent.beca.model.ReporteActividad;
import edu.calc.json.horarios.common.utils.Constant;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * @author Marcos Santiago Leonardo
 * Universidad de la Sierra Sur (UNSIS)
 * Description:
 * Date: 2019-06-16
 */
@Repository
public class ReportPercentBecaDaoImpl extends BaseDao implements ReportPercentBecaDao {

    public ReportPercentBecaDaoImpl(JdbcTemplate jdbcTemplate) {
        super(jdbcTemplate);
    }

    @Override
    public boolean actividadAlumnoExists(ActividadVo actividadVo) {
        try {
            int countAlumno = jdbcTemplate.queryForObject(
                    QueriesReportPercentBeca.QRY_COUNT_ID_ACTIVIDAD_ALUMNO,
                    new Object[]{actividadVo.getIdActividad()},
                    Integer.class);
            return countAlumno > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public WrapperData getAll(Pageable pageableQ, ReporteActividad filter) {
        boolean pageable = pageableQ.getPageSize() != Integer.parseInt(Constant.ITEMS_FOR_PAGE);
        String queryGetALl = QueriesReportPercentBeca.QRY_SELECT_DATA_REPORT.concat(QueriesReportPercentBeca.QRY_FROM_DATA_REPORTE_ACTIVIDADES);
        String queryCountALl = QueriesReportPercentBeca.QRY_COUNT_DATA_REPORT.concat(QueriesReportPercentBeca.QRY_FROM_DATA_REPORTE_ACTIVIDADES);

        String conditions = createCondition(filter);
        queryGetALl = queryGetALl.concat(conditions);
        queryCountALl = queryCountALl.concat(conditions);
        queryGetALl = queryGetALl.concat(QueriesReportPercentBeca.QRY_ORDER_BY);

        queryGetALl = addQueryPageable(pageableQ.getPage(), pageableQ.getPageSize(), queryGetALl);

        int lengthDataTable = this.jdbcTemplate.queryForObject(queryCountALl, Integer.class);

        List<ReporteActividad> data = this.jdbcTemplate.query(queryGetALl, (rs, rowNum) -> mapperReporteActividad(rs));

        int page = pageableQ.getPage();
        int pageSize = pageableQ.getPageSize();

        if (!pageable) {
            page = 0;
            pageSize = lengthDataTable;
        }
        return new WrapperData(data, page, pageSize, lengthDataTable);
    }

    private String createCondition(ReporteActividad filter) {
        String conditions = "";
        if (filter.getIdActividad() != 0) {
            conditions = conditions.concat(String.format(QueriesReportPercentBeca.ADD_CONDITION_ACTIVIDAD, filter.getIdActividad()));
        }

        if (filter.getIdCicloEscolar() != 0) {
            conditions = conditions.concat(String.format(QueriesReportPercentBeca.ADD_CONDITION_CICLO_ESCOLAR, filter.getIdCicloEscolar()));
        }

        if (filter.getIdGrupo() != 0) {
            conditions = conditions.concat(String.format(QueriesReportPercentBeca.ADD_CONDITION_GRUPO, filter.getIdGrupo()));
        }

        if (filter.getIdLicenciatura() != 0) {
            conditions = conditions.concat(String.format(QueriesReportPercentBeca.ADD_CONDITION_LICENCIATURA, filter.getIdLicenciatura()));
        }

        if (filter.getIdParcial() != 0) {
            conditions = conditions.concat(String.format(QueriesReportPercentBeca.ADD_CONDITION_PARCIAL, filter.getIdParcial()));
        }

        if (filter.getPalabraClave() != null && !filter.getPalabraClave().trim().equalsIgnoreCase("")) {
            conditions = conditions.concat(String.format(QueriesReportPercentBeca.ADD_CONDITION_LIKE_WORD_KEY, "'%" + filter.getPalabraClave() + "%'"));
        }

        return conditions;
    }

    private ReporteActividad mapperReporteActividad(ResultSet rs) throws SQLException {
        ReporteActividad reporte = new ReporteActividad();
        reporte.setIdPorcentajeBeca(rs.getInt("ID_PORCENTAJE_BECA"));
        reporte.setIdAlumno(rs.getInt("ID_ALUMNO"));
        reporte.setMatricula(rs.getString("MATRICULA"));
        reporte.setNombres(rs.getString("NOMBRES"));
        reporte.setApePaterno(rs.getString("APE_PATERNO"));
        reporte.setApeMaterno(rs.getString("APE_MATERNO"));
        reporte.setIdActividadAlumno(rs.getInt("ID_ACTIVIDAD_ALUMNO"));
        reporte.setPorcentajeSala(rs.getInt("PORCENTAJE_SALA"));
        reporte.setPorcentajeBiblioteca(rs.getInt("PORCENTAJE_BIBLIOTECA"));
        reporte.setPorcentajeActividad(rs.getInt("PORCENTAJE_ACTIVIDAD"));
        reporte.setIdActividad(rs.getInt("ID_ACTIVIDAD"));
        reporte.setNombreActividad(rs.getString("NOMBRE_ACTIVIDAD"));
        reporte.setIdParcial(rs.getInt("ID_PARCIAL"));
        reporte.setDescParcial(rs.getString("DESC_PARCIAL"));
        reporte.setIdCicloEscolar(rs.getInt("ID_CICLO_ESCOLAR"));
        reporte.setDescCicloEscolar(rs.getString("DESCRIPCION_CICLO"));
        reporte.setIdGrupo(rs.getInt("ID_GRUPO"));
        reporte.setCveGrupo(rs.getString("CVE_GRUPO"));
        reporte.setIdLicenciatura(rs.getInt("ID_LICENCIATURA"));
        reporte.setCveLicenciatura(rs.getString("CVE_LICENCIATURA"));
        reporte.setNombreLicenciatura(rs.getString("NOMBRE_LICENCIATURA"));
        return reporte;
    }
}
