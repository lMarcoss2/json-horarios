package edu.calc.becas.mconfiguracion.parciales.service;

import edu.calc.becas.mconfiguracion.parciales.dao.ParcialDao;
import edu.calc.becas.mconfiguracion.parciales.model.Parcial;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Marcos Santiago Leonardo
 * Universidad de la Sierra Sur (UNSIS)
 * Description: Implementación de servicios para la tabla PARCIAL
 * Date: 4/9/19
 */
@Service
public class ParcialServiceImpl implements ParcialService {

    private final ParcialDao parcialDao;

    @Autowired
    public ParcialServiceImpl(ParcialDao parcialDao) {
        this.parcialDao = parcialDao;
    }

    @Override
    public List<Parcial> getAll(String cvePeriodo) {
        return this.parcialDao.getAll(cvePeriodo);
    }

    @Override
    public Parcial update(Parcial parcial) {
        return this.parcialDao.update(parcial);
    }

    @Override
    public Parcial getParcialActual() {
        return parcialDao.getParcialActual();
    }
}
