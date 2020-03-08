package edu.calc.json.horarios.reporte.percent.beca.service;

import edu.calc.json.horarios.common.model.Pageable;
import edu.calc.json.horarios.common.model.WrapperData;
import edu.calc.json.horarios.reporte.percent.beca.model.ReporteActividad;

/**
 * @author Marcos Santiago Leonardo
 * Meltsan Solutions
 * Description:
 * Date: 2019-07-10
 */
public interface ReportPercentBecaService {
    WrapperData getAll(Pageable pageable, ReporteActividad reporteActividad);
}
