package edu.calc.json.horarios.mcatalogos.grupos.service;

import edu.calc.json.horarios.common.service.CrudGenericService;
import edu.calc.json.horarios.mcatalogos.grupos.model.Grupo;

import java.util.List;

/**
 * @author Marcos Santiago Leonardo
 * Universidad de la Sierra Sur (UNSIS)
 * Description:
 * Date: 3/26/19
 */
public interface GrupoService extends CrudGenericService<Grupo> {
    List<Grupo> getAllByPeriodo(String periodo);
}
