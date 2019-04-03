package edu.calc.becas.mcatalogos.grupos.dao;

import edu.calc.becas.mcatalogos.grupos.model.Grupo;
import edu.calc.becas.common.model.WrapperData;

/**
 * @author Marcos Santiago Leonardo
 * Universidad de la Sierra Sur (UNSIS)
 * Description:
 * Date: 3/26/19
 */
public interface GrupoDao {
    WrapperData getAll(int page, int pageSize);

    Grupo add(Grupo grupo);

    Grupo update(Grupo grupo);
}
