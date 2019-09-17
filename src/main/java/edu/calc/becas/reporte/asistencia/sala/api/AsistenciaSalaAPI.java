package edu.calc.becas.reporte.asistencia.sala.api;

import edu.calc.becas.reporte.asistencia.sala.model.AlumnoAsistenciaSala;
import edu.calc.becas.reporte.asistencia.sala.service.AsistenciaSalaService;
import edu.calc.becas.utils.UtilDate;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
    public List<AlumnoAsistenciaSala> getAlumnosByScheduleAndUser(@PathVariable String username, @PathVariable("id-horario") String idHorario) {
        return asistenciaSalaService.getAlumnosByScheduleAndUser(username, idHorario);
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
            fechas.add(UtilDate.convertDateToString(fechaInicial));
        }

        while (fechaInicial.before(fechaFinal)) {
            fechaInicial = UtilDate.getNextDayBySum(fechaInicial, 1);
            day = fechaInicial.getDay();
            if (day >= 1 && day <= 5) {
                fechas.add(UtilDate.convertDateToString(fechaInicial));
            }
        }
        return fechas;
    }

}
