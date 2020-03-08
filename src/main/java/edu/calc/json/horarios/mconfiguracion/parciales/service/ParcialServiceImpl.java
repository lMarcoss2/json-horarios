package edu.calc.json.horarios.mconfiguracion.parciales.service;

import edu.calc.json.horarios.common.model.WrapperData;
import edu.calc.json.horarios.mconfiguracion.parciales.dao.ParcialDao;
import edu.calc.json.horarios.mconfiguracion.parciales.model.Parcial;
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
    public WrapperData getAllByStatus(int page, int pageSize, String status) {
        return null;
    }

    @Override
    public WrapperData getAllByStatusAndOneParam(int page, int pageSize, String status, String param1) {
        return null;
    }

    @Override
    public Parcial add(Parcial parcial) {
        return parcialDao.add(parcial);
    }

    @Override
    public Parcial update(Parcial parcial) {
        return this.parcialDao.update(parcial);
    }

    @Override
    public List<Parcial> getAllByPeriodo(String cvePeriodo) {
        return this.parcialDao.getAllByPeriodo(cvePeriodo);
    }

    @Override
    public Parcial getParcialActual() {
        return parcialDao.getParcialActual();
    }
}
