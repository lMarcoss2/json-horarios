package edu.calc.becas.reporte.percent.beca.dao;

import edu.calc.becas.common.base.dao.BaseDao;
import edu.calc.becas.common.model.WrapperData;
import edu.calc.becas.mcatalogos.actividades.model.ActividadVo;
import edu.calc.becas.reporte.percent.beca.model.ReporteActividad;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import static edu.calc.becas.common.utils.Constant.ITEMS_FOR_PAGE;
import static edu.calc.becas.reporte.percent.beca.dao.QueriesReportPercentBeca.*;

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
                    QRY_COUNT_ID_ACTIVIDAD_ALUMNO,
                    new Object[]{actividadVo.getIdActividad()},
                    Integer.class);
            return countAlumno > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public WrapperData getAll(int page, int pageSize) {
        boolean pageable = pageSize != Integer.parseInt(ITEMS_FOR_PAGE);
        String queryGetALl = QRY_GET_REPORTE_ACTIVIDADES;


        queryGetALl = queryGetALl.concat(QRY_ORDER_BY);

        queryGetALl = addQueryPageable(page, pageSize, queryGetALl);

        int lengthDataTable = this.jdbcTemplate.queryForObject(createQueryCountItem(queryGetALl), Integer.class);

        List<ReporteActividad> data = this.jdbcTemplate.query(queryGetALl, (rs, rowNum) -> mapperReporteActividad(rs));

        if (!pageable) {
            page = 0;
            pageSize = lengthDataTable;
        }
        return new WrapperData(data, page, pageSize, lengthDataTable);
    }

    private ReporteActividad mapperReporteActividad(ResultSet rs) throws SQLException {
        ReporteActividad reporte = new ReporteActividad();
        /*
                    "FROM PORCENTAJE_BECA P,\n" +
                    "     PARCIALES PA,\n" +
                    "     ACTIVIDAD_ALUMNO AL,\n" +
                    "     ACTIVIDADES AC,\n" +
                    "     ALUMNOS A,\n" +
                    "     GRUPOS G,\n" +
                    "     LICENCIATURAS L\n" +
                    "WHERE P.ID_PARCIAL = PA.ID_PARCIAL\n" +
                    "  AND P.ID_ACTIVIDAD_ALUMNO = AL.ID_ACTIVIDAD_ALUMNO\n" +
                    "  AND A.ESTATUS = 'S'\n" +
                    "  AND G.ESTATUS = 'S'\n" +
                    "  AND L.ESTATUS = 'S'\n" +
                    "  AND AC.ESTATUS = 'S'\n" +
                    "  AND AL.ID_GRUPO = G.ID_GRUPO\n" +
                    "  AND AL.ID_ACTIVIDAD = AC.ID_ACTIVIDAD\n" +
                    "  AND G.ID_LICENCIATURA = L.ID_LICENCIATURA\n" +
                    "  AND AL.ID_ALUMNO = A.ID_ALUMNO\
        * */
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
        reporte.setIdGrupo(rs.getInt("ID_GRUPO"));
        reporte.setCveGrupo(rs.getString("CVE_GRUPO"));
        reporte.setIdLicenciatura(rs.getInt("ID_LICENCIATURA"));
        reporte.setCveLicenciatura(rs.getString("CVE_LICENCIATURA"));
        reporte.setNombreLicenciatura(rs.getString("NOMBRE_LICENCIATURA"));
        return reporte;
    }
}
