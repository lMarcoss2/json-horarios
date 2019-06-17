package edu.calc.becas.mcarga.hrs.sala.dao;

import edu.calc.becas.common.base.dao.BaseDao;
import edu.calc.becas.malumnos.actividades.dao.AlumnoActividadDao;
import edu.calc.becas.malumnos.model.Alumno;
import edu.calc.becas.mcarga.hrs.CargaHrsDao;
import edu.calc.becas.mcatalogos.actividades.model.ActividadVo;
import edu.calc.becas.reporte.percent.beca.dao.ReportPercentBecaDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

import static edu.calc.becas.mcarga.hrs.sala.dao.QueriesCargaHrsSala.QRY_INSERT_PERCENT_SALA;
import static edu.calc.becas.mcarga.hrs.sala.dao.QueriesCargaHrsSala.QRY_UPDATE_PERCENT_SALA;

/**
 * @author Marcos Santiago Leonardo
 * Universidad de la Sierra Sur (UNSIS)
 * Description:
 * Date: 6/3/19
 */
@Repository("cargaHrsSalaRepository")
public class CargaHrsSalaDaoImpl extends BaseDao implements CargaHrsDao {

    private final static Logger LOG = LoggerFactory.getLogger(CargaHrsSalaDaoImpl.class);

    private final ReportPercentBecaDao reportPercentBecaDao;
    private final AlumnoActividadDao alumnoActividadDao;

    public CargaHrsSalaDaoImpl(JdbcTemplate jdbcTemplate,
                               ReportPercentBecaDao reportPercentBecaDao,
                               AlumnoActividadDao alumnoActividadDao) {
        super(jdbcTemplate);
        this.reportPercentBecaDao = reportPercentBecaDao;
        this.alumnoActividadDao = alumnoActividadDao;
    }

    @Override
    public void persistenceHours(List<Alumno> alumnos, int parcial) {
        for (Alumno alumno : alumnos) {
            try {
                // obtiene la actividad del alumno
                ActividadVo actividadVo = alumnoActividadDao.getActividadByAlumno(alumno.getMatricula());

                if (reportPercentBecaDao.actividadAlumnoExists(actividadVo)) {
                    jdbcTemplate.update(QRY_UPDATE_PERCENT_SALA,
                            new Object[]{
                                    alumno.getAsistenciaSala().getPorcentaje(),
                                    actividadVo.getIdActividad(),
                                    parcial
                            });
                } else {
                    jdbcTemplate.update(QRY_INSERT_PERCENT_SALA,
                            actividadVo.getIdActividad(),
                            alumno.getAsistenciaSala().getPorcentaje(),
                            parcial,
                            alumno.getAgregadoPor()
                    );
                }


            } catch (Exception e) {
                LOG.error(e.getMessage());
            }

        }
    }

}
