package edu.calc.becas.malumnos.actividades.api;

import edu.calc.becas.malumnos.actividades.service.AlumnoActividadService;
import edu.calc.becas.mcatalogos.actividades.model.ActividadVo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Marcos Santiago Leonardo
 * Universidad de la Sierra Sur (UNSIS)
 * Description: Api para exponer servicios de consulta de actividades por alumno(s)
 * Date: 2019-06-16
 */
@RestController
@RequestMapping()
public class AlumnoActividadAPI {

    private final AlumnoActividadService alumnoActividadService;

    public AlumnoActividadAPI(AlumnoActividadService alumnoActividadService) {
        this.alumnoActividadService = alumnoActividadService;
    }

    @GetMapping("/alumnos/{matricula}/actividades")
    public ActividadVo getActividadByAlumno(@PathVariable String matricula) {
        return alumnoActividadService.getActividadByAlumno(matricula);
    }
}
