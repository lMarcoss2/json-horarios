package edu.calc.becas.reporte.asistencia.sala.api;

import edu.calc.becas.reporte.asistencia.sala.model.AlumnoAsistenciaSala;
import edu.calc.becas.reporte.asistencia.sala.model.WrapperAsistenciaAlumno;
import edu.calc.becas.reporte.asistencia.sala.service.AsistenciaSalaService;
import edu.calc.becas.utils.UtilDate;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static edu.calc.becas.common.utils.Constant.TODAY;

@RestController
@RequestMapping("/asistencia-sala")
@Api(description = "Servicios para consultar asistencia de alumnos en sala de cómputo por usuario")
public class AsistenciaSalaAPI {

    private final AsistenciaSalaService asistenciaSalaService;

    public AsistenciaSalaAPI(AsistenciaSalaService asistenciaSalaService) {
        this.asistenciaSalaService = asistenciaSalaService;
    }

    @GetMapping("/{username}/{id-horario}")
    @ApiOperation(value = "Obtiene la lista de alumnos por horario")
    public WrapperAsistenciaAlumno getAlumnosByScheduleAndUser(
            @ApiParam(value = "Username", required = true) @PathVariable String username,
            @ApiParam(value = "Identificador-horario", required = true) @PathVariable("id-horario") String idHorario,
            @ApiParam(value = "Fecha inicio", defaultValue = TODAY) @RequestParam(value = "fecha-inicio", defaultValue = TODAY, required = false) String fechaInicio,
            @ApiParam(value = "Fecha Fin", defaultValue = TODAY) @RequestParam(value = "fecha-fin", defaultValue = TODAY, required = false) String fechaFin) throws Exception {
        WrapperAsistenciaAlumno asistenciaAlumno = new WrapperAsistenciaAlumno();

        List<AlumnoAsistenciaSala> alumnos = asistenciaSalaService.getAlumnosByScheduleAndUser(username, idHorario);
        asistenciaAlumno.setAlumnos(alumnos);

        if (fechaInicio.equalsIgnoreCase(TODAY)) {
            Date today = new Date();
            fechaInicio = UtilDate.convertDateToString(today, UtilDate.PATTERN_GUION);
        }

        if (fechaFin.equalsIgnoreCase(TODAY)) {
            Date today = new Date();
            fechaFin = UtilDate.convertDateToString(today, UtilDate.PATTERN_GUION);
        }

        List<String> fechas = this.getFechas(fechaInicio, fechaFin);

        asistenciaAlumno.setFechas(fechas);
        return asistenciaAlumno;
    }

    @GetMapping("/fechas/{fecha-inicio}/{fecha-fin}")
    @ApiOperation(value = "Obtiene el periodo de asistencias entre una fecha de inicio y fin (dd-mm-yyyy)")
    public List<String> getFechas(@ApiParam(value = "Fecha inicio", required = true) @PathVariable("fecha-inicio") String fechaInicio,
                                  @ApiParam(value = "Fecha fin", required = true) @PathVariable("fecha-fin") String fechaFin) throws Exception {

        Date fechaInicial = UtilDate.convertToDate(fechaInicio);
        Date fechaFinal = UtilDate.convertToDate(fechaFin);

        List<String> fechas = new ArrayList<>();
        int day = fechaInicial.getDay();
        if (day >= 1 && day <= 5) {
            fechas.add(UtilDate.convertDateToString(fechaInicial, UtilDate.PATTERN_DIAG));
        }

        while (fechaInicial.before(fechaFinal)) {
            fechaInicial = UtilDate.getNextDayBySum(fechaInicial, 1);
            day = fechaInicial.getDay();
            if (day >= 1 && day <= 5) {
                fechas.add(UtilDate.convertDateToString(fechaInicial, UtilDate.PATTERN_DIAG));
            }
        }
        return fechas;
    }

}
