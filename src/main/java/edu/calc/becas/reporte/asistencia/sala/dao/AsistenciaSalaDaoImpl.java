package edu.calc.becas.reporte.asistencia.sala.dao;

import edu.calc.becas.common.base.dao.BaseDao;
import edu.calc.becas.malumnos.model.Alumno;
import edu.calc.becas.reporte.asistencia.sala.model.AlumnoAsistenciaSala;
import edu.calc.becas.reporte.asistencia.sala.model.FechaAsistencia;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static edu.calc.becas.reporte.asistencia.sala.dao.QueriesAsistenciaSala.GET_ALUMNOS_BY_USER_AND_SCHEDULE;
import static edu.calc.becas.reporte.asistencia.sala.dao.QueriesAsistenciaSala.QRY_GET_ASISTENCIA_BY_ACTIVIDAD_ALUMNO;

@Repository
public class AsistenciaSalaDaoImpl extends BaseDao implements AsistenciaSalaDao {

    public AsistenciaSalaDaoImpl(JdbcTemplate jdbcTemplate) {
        super(jdbcTemplate);
    }

    @Override
    public List<AlumnoAsistenciaSala> getAlumnosByScheduleAndUser(String username, String idHorario) {
        return jdbcTemplate.query(GET_ALUMNOS_BY_USER_AND_SCHEDULE, new Object[]{username, idHorario}, ((rs, i) -> mapperAlumnos(rs)));
    }

    @Override
    public void getPresenceByDate(List<AlumnoAsistenciaSala> alumnos, List<FechaAsistencia> fechas) {
        long l = System.currentTimeMillis();
        System.out.println(l);
        alumnos.forEach(alumno -> {
            List<FechaAsistencia> asistencias = new ArrayList<>();
            fechas.forEach(fecha -> {
                fecha.setIdActividadAlumno(alumno.getIdActividadAlumno());
                try {
                    fecha.setAsistencia(
                            jdbcTemplate.queryForObject(QRY_GET_ASISTENCIA_BY_ACTIVIDAD_ALUMNO, new Object[]{alumno.getIdActividadAlumno(), fecha}, String.class)
                    );
                }catch (IncorrectResultSizeDataAccessException e){
                    fecha.setAsistencia(null);
                }
                asistencias.add(fecha);
            });
            alumno.setAsistencia(asistencias);
        });
    }

    private FechaAsistencia mapperAsistenciaAlumno(ResultSet rs) {
        return null;
    }

    private AlumnoAsistenciaSala mapperAlumnos(ResultSet rs) throws SQLException {
        AlumnoAsistenciaSala alumnoAsistenciaSala = new AlumnoAsistenciaSala();
        Alumno alumno = new Alumno();
        alumno.setNombres(rs.getString("NOMBRES"));
        alumno.setApePaterno(rs.getString("APE_PATERNO"));
        alumno.setApeMaterno(rs.getString("APE_MATERNO"));

        alumnoAsistenciaSala.setAlumno(alumno);

        alumnoAsistenciaSala.setIdActividadAlumno(rs.getInt("ID_ACTIVIDAD_ALUMNO"));

        alumnoAsistenciaSala.setIdHorarioActividad(rs.getInt("ID_HORARIO_ACTIVIDAD"));
        //alumnoAsistenciaSala.setAsistencia(true);
        return alumnoAsistenciaSala;
    }
}
