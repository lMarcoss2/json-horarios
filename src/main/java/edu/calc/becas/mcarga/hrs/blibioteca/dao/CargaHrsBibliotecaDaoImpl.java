package edu.calc.becas.mcarga.hrs.blibioteca.dao;

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

import static edu.calc.becas.mcarga.hrs.blibioteca.dao.QueriesCargaHrsBiblioteca.QRY_INSERT_PERCENT_BIBLIOTECA;
import static edu.calc.becas.mcarga.hrs.blibioteca.dao.QueriesCargaHrsBiblioteca.QRY_UPDATE_PERCENT_BIBLIOTECA;

/**
 * @author Marcos Santiago Leonardo
 * Universidad de la Sierra Sur (UNSIS)
 * Description:
 * Date: 6/3/19
 */
@Repository("cargaHrsBibliotecaRepository")
public class CargaHrsBibliotecaDaoImpl extends BaseDao implements CargaHrsDao {
    private static final Logger LOG = LoggerFactory.getLogger(CargaHrsBibliotecaDaoImpl.class);


    private final ReportPercentBecaDao reportPercentBecaDao;
    private final AlumnoActividadDao alumnoActividadDao;

    public CargaHrsBibliotecaDaoImpl(JdbcTemplate jdbcTemplate,
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
                // obtiene datos del alumno
                /*Alumno alumnoBD = alumnosService.getByMatricula(alumno.getMatricula());*/

                // obtiene la actividad del alumno
                ActividadVo actividadVo = alumnoActividadDao.getActividadByAlumno(alumno.getMatricula());

                if (reportPercentBecaDao.actividadAlumnoExists(actividadVo)) {
                    jdbcTemplate.update(QRY_UPDATE_PERCENT_BIBLIOTECA,
                            new Object[]{
                                    alumno.getHora(),
                                    actividadVo.getIdActividad(),
                                    parcial
                            });
                } else {
                    jdbcTemplate.update(QRY_INSERT_PERCENT_BIBLIOTECA,
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
