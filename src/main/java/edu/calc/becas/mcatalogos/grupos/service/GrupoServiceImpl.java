package edu.calc.becas.mcatalogos.grupos.service;

import edu.calc.becas.common.model.WrapperData;
import edu.calc.becas.mcatalogos.grupos.dao.GrupoDao;
import edu.calc.becas.mcatalogos.grupos.model.Grupo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Marcos Santiago Leonardo
 * Universidad de la Sierra Sur (UNSIS)
 * Description:
 * Date: 3/26/19
 */
@Service
public class GrupoServiceImpl implements GrupoService {

    private final GrupoDao grupoDao;

    @Autowired
    public GrupoServiceImpl(GrupoDao grupoDao) {
        this.grupoDao = grupoDao;
    }

    @Override
    public WrapperData getAll(int page, int pageSize, String status) {
        return grupoDao.getAll(page, pageSize, status);
    }

    @Override
    public Grupo add(Grupo grupo) {
        return grupoDao.add(grupo);
    }

    @Override
    public Grupo update(Grupo grupo) {
        return grupoDao.update(grupo);
    }
}
