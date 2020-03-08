package edu.calc.json.horarios.reporte.percent.beca.dao;

import edu.calc.json.horarios.common.model.Pageable;
import edu.calc.json.horarios.common.model.WrapperData;
import edu.calc.json.horarios.mcatalogos.actividades.model.ActividadVo;
import edu.calc.json.horarios.reporte.percent.beca.model.ReporteActividad;


/**
 * @author Marcos Santiago Leonardo
 * Universidad de la Sierra Sur (UNSIS)
 * Description:
 * Date: 2019-06-16
 */
public interface ReportPercentBecaDao {
    boolean actividadAlumnoExists(ActividadVo actividadVo);

    WrapperData getAll(Pageable pageable, ReporteActividad reporteActividad);
}
