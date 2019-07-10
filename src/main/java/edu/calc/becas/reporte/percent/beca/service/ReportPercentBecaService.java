package edu.calc.becas.reporte.percent.beca.service;

import edu.calc.becas.common.model.WrapperData;

/**
 * @author Marcos Santiago Leonardo
 * Meltsan Solutions
 * Description:
 * Date: 2019-07-10
 */
public interface ReportPercentBecaService {
    WrapperData getAll(int page, int pageSize);
}
