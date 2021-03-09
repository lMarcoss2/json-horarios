package edu.calc.json.horarios.mcatalogos.licenciaturas.service;

import edu.calc.json.horarios.common.service.CrudGenericService;
import edu.calc.json.horarios.mcatalogos.licenciaturas.model.Licenciatura;

import java.util.List;

/**
 * @author Marcos Santiago Leonardo
 * Universidad de la Sierra Sur (UNSIS)
 * Description: Services definition for majors
 * Date: 3/23/19
 */
public interface LicenciaturaService extends CrudGenericService<Licenciatura> {
    Licenciatura getDetalleCarrera(String clave) throws Exception;
    
    List<Licenciatura> getAllVigentes() throws Exception;
}

