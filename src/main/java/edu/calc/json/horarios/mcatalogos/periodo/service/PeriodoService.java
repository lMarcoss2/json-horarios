package edu.calc.json.horarios.mcatalogos.periodo.service;

import edu.calc.json.horarios.common.service.CrudGenericService;
import edu.calc.json.horarios.exceptions.GenericException;
import edu.calc.json.horarios.mcatalogos.periodo.model.Periodo;

public interface PeriodoService extends CrudGenericService<Periodo> {

    Periodo getCicloEscolarActual() throws GenericException;
}
