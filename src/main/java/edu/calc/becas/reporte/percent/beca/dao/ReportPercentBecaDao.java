package edu.calc.becas.reporte.percent.beca.dao;

import edu.calc.becas.common.model.WrapperData;
import edu.calc.becas.mcatalogos.actividades.model.ActividadVo;


/**
 * @author Marcos Santiago Leonardo
 * Universidad de la Sierra Sur (UNSIS)
 * Description:
 * Date: 2019-06-16
 */
public interface ReportPercentBecaDao {
    boolean actividadAlumnoExists(ActividadVo actividadVo);

    WrapperData getAll(int page, int pageSize);
}
