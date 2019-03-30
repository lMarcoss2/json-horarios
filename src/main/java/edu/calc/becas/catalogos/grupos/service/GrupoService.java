package edu.calc.becas.catalogos.grupos.service;

import edu.calc.becas.catalogos.grupos.model.Grupo;
import edu.calc.becas.common.model.WrapperData;

/**
 * @author Marcos Santiago Leonardo
 * Universidad de la Sierra Sur (UNSIS)
 * Description:
 * Date: 3/26/19
 */
public interface GrupoService {
    WrapperData getAll(int page, int pageSize);

    Grupo add(Grupo grupo);

    Grupo update(Grupo grupo);
}
