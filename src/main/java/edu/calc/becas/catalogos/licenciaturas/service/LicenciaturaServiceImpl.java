package edu.calc.becas.catalogos.licenciaturas.service;

import edu.calc.becas.catalogos.licenciaturas.dao.LicenciaturaDao;
import edu.calc.becas.catalogos.licenciaturas.model.Licenciatura;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Marcos Santiago Leonardo
 * Universidad de la Sierra Sur (UNSIS)
 * Description:
 * Date: 3/23/19
 */
@Service
public class LicenciaturaServiceImpl implements LicenciaturaService {

    private final LicenciaturaDao licenciaturaDao;

    @Autowired
    public LicenciaturaServiceImpl(LicenciaturaDao licenciaturaDao) {
        this.licenciaturaDao = licenciaturaDao;
    }

    @Override
    public List<Licenciatura> getAll() {
        return licenciaturaDao.getAll();
    }
}
