package edu.calc.json.horarios.mcarga.hrs.blibioteca.dao;

import edu.calc.json.horarios.common.base.dao.BaseDao;
import edu.calc.json.horarios.malumnos.actividades.dao.AlumnoActividadDao;
import edu.calc.json.horarios.malumnos.model.Alumno;
import edu.calc.json.horarios.mcarga.hrs.CargaHrsDao;
import edu.calc.json.horarios.mcatalogos.actividades.model.ActividadVo;
import edu.calc.json.horarios.mconfiguracion.cicloescolar.model.CicloEscolarVo;
import edu.calc.json.horarios.mconfiguracion.parciales.model.Parcial;
import edu.calc.json.horarios.reporte.percent.beca.dao.ReportPercentBecaDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

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
    public int persistenceHours(List<Alumno> alumnos, Parcial parcialActual, CicloEscolarVo cicloEscolarActual) {
        int count = 0;
        for (Alumno alumno : alumnos) {
            try {
                // obtiene datos del alumno
                /*Alumno alumnoBD = alumnosService.getByMatricula(alumno.getMatricula());*/
                int percentLibraryTime = calculatePercentHoursLibrary(alumno, parcialActual);
                // obtiene la actividad del alumno
                ActividadVo actividadVo = alumnoActividadDao.getActividadByAlumno(alumno.getMatricula(), cicloEscolarActual);

                if (reportPercentBecaDao.actividadAlumnoExists(actividadVo)) {
                    jdbcTemplate.update(QueriesCargaHrsBiblioteca.QRY_UPDATE_PERCENT_BIBLIOTECA,
                            new Object[]{
                                    percentLibraryTime,
                                    actividadVo.getIdActividad(),
                                    parcialActual.getIdParcial()
                            });
                } else {
                    jdbcTemplate.update(QueriesCargaHrsBiblioteca.QRY_INSERT_PERCENT_BIBLIOTECA,
                            actividadVo.getIdActividad(),
                            percentLibraryTime,
                            parcialActual.getIdParcial(),
                            cicloEscolarActual.getClave(),
                            cicloEscolarActual.getNombre(),
                            alumno.getAgregadoPor()
                    );
                }

                count++;
            } catch (Exception e) {
                LOG.error(e.getMessage());
            }

        }
        return count;
    }

    private int calculatePercentHoursLibrary(Alumno alumno, Parcial parcialActual) {
        int horasParcial = parcialActual.getTotalHorasBiblioteca() * 60;

        int horasALumno = 0;
        if (alumno.getHora() != null) {
            horasALumno = (alumno.getHora().getNumHora() * 60) + alumno.getHora().getNumMinutos();
        }
        return (horasALumno * 100) / horasParcial;
    }

}
