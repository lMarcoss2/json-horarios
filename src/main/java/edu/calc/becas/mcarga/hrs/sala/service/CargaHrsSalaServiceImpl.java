package edu.calc.becas.mcarga.hrs.sala.service;

import edu.calc.becas.malumnos.model.Alumno;
import edu.calc.becas.mcarga.hrs.CargaHrsDao;
import edu.calc.becas.mcarga.hrs.ProcessHoursService;
import edu.calc.becas.mcarga.hrs.ProcessRow;
import edu.calc.becas.mcarga.hrs.read.files.model.RowFile;
import edu.calc.becas.mcarga.hrs.sala.model.Asistencia;
import edu.calc.becas.mcatalogos.actividades.model.ActividadVo;
import org.apache.poi.ss.usermodel.Workbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static edu.calc.becas.mcarga.hrs.sala.constants.ConstantsProcessedHrs.VALUE_FORMULA;
import static java.math.BigDecimal.ROUND_HALF_UP;

/**
 * @author Marcos Santiago Leonardo
 * Universidad de la Sierra Sur (UNSIS)
 * Description: Processed asistences room computer
 * Date: 3/06/19
 */
@Service("cargaHrsSalaService")
public class CargaHrsSalaServiceImpl extends ProcessRow implements ProcessHoursService {

    private static final Logger LOG = LoggerFactory.getLogger(CargaHrsSalaServiceImpl.class);
    private final CargaHrsDao cargaHrsDao;

    @Value("${prop.carga.hrs.sala.id}")
    private int idActividadSala;

    @Value("${prop.carga.hrs.sala.posicion.matricula}")
    private int posMatricula;

    @Value("${prop.carga.hrs.sala.posicion.nombre}")
    private int posNombreCompleto;

    @Value("${prop.carga.hrs.sala.posicion.asistencia.inicio}")
    private int posInicioAsistencia;

    @Value("${prop.carga.hrs.sala.asistencia.asistencia}")
    private String asistencia;

    @Value("${prop.carga.hrs.sala.asistencia.falta}")
    private String falta;

    @Autowired
    public CargaHrsSalaServiceImpl(@Qualifier("cargaHrsSalaRepository") CargaHrsDao cargaHrsDao) {
        this.cargaHrsDao = cargaHrsDao;
    }

    @Override
    public void processData(Workbook pages) {
        List<RowFile> rows = readRows(pages);

        List<Alumno> alumnos = new ArrayList<>();

        for (RowFile row : rows) {

            Alumno alumno = new Alumno();
            ActividadVo actividadVo = new ActividadVo("S");
            actividadVo.setIdActividad(idActividadSala);
            alumno.setActividad(actividadVo);


            int asistence = 0;
            int missing = 0;

            // proccesed cells by row
            for (int i = 0; i < row.getCells().size(); i++) {
                if (i == posMatricula) {
                    alumno.setMatricula(row.getCells().get(i).getValue());
                }

                if (i == posNombreCompleto) {
                    alumno.setNombres(row.getCells().get(i).getValue());
                }

                String value = row.getCells().get(i).getValue();
                if (i >= posInicioAsistencia && !endAssits(value)) {
                    if (isAssistence(value)) {
                        asistence++;
                    } else if (isMissing(value)) {
                        missing++;
                    }
                }
            }
            if (asistence > 0) {

                BigDecimal sum = BigDecimal.valueOf(asistence + missing);
                BigDecimal assis = BigDecimal.valueOf(asistence);
                BigDecimal multiplica = assis.multiply(BigDecimal.valueOf(100));
                BigDecimal percent = multiplica.divide(sum, 0, ROUND_HALF_UP);

                Asistencia asistencia = new Asistencia();
                asistencia.setAsistencia(asistence);
                asistencia.setFalta(missing);
                asistencia.setPorcentaje(percent.intValue());
                alumno.setAsistencia(asistencia);
            }
            alumnos.add(alumno);
        }
        for (Alumno alumno : alumnos) {
            LOG.info(alumno.toString());
        }
        //this.cargaHrsBibliotecaDao.persistenceHours(alumnos);
    }

    private boolean endAssits(String value) {
        // todo : sólo si es formula terminar
        if (value == null) {
            return true;
        }

        if (value.equalsIgnoreCase("")) {
            return true;
        }
        return value.equalsIgnoreCase(VALUE_FORMULA.name());
    }

    private boolean isMissing(String value) {
        return value.equalsIgnoreCase(falta);
    }

    private boolean isAssistence(String value) {
        return value.equalsIgnoreCase(asistencia);
    }


}
