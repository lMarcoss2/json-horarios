package edu.calc.json.horarios.mseguridad.rolesypermisos.service;

import edu.calc.json.horarios.common.model.WrapperData;
import edu.calc.json.horarios.mseguridad.rolesypermisos.dao.RolDao;
import edu.calc.json.horarios.mseguridad.rolesypermisos.model.Rol;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Marcos Santiago Leonardo
 * Universidad de la Sierra Sur (UNSIS)
 * Description:
 * Date: 4/14/19
 */
@Service
public class RolServiceImpl implements RolService {

    private final RolDao rolDao;

    @Autowired
    public RolServiceImpl(RolDao rolDao) {
        this.rolDao = rolDao;
    }

    @Override
    public WrapperData getAllByStatus(int page, int pageSize, String status) {
        return rolDao.getAllByStatus(page, pageSize, status);
    }

    @Override
    public WrapperData getAllByStatusAndOneParam(int page, int pageSize, String status, String tipoUsuario) {
        return null;
    }

    @Override
    public Rol add(Rol rol) {
        return null;
    }

    @Override
    public Rol update(Rol rol) {
        return null;
    }
}
