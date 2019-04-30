package edu.calc.becas.mseguridad.usuarios.service;

import edu.calc.becas.common.model.WrapperData;
import edu.calc.becas.mseguridad.usuarios.dao.UsuarioDao;
import edu.calc.becas.mseguridad.usuarios.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Marcos Santiago Leonardo
 * Universidad de la Sierra Sur (UNSIS)
 * Description:
 * Date: 4/14/19
 */
@Service
public class UsuarioServiceImpl implements UsuarioService {

    private final UsuarioDao usuarioDao;

    @Autowired
    public UsuarioServiceImpl(UsuarioDao usuarioDao) {
        this.usuarioDao = usuarioDao;
    }

    @Override
    public WrapperData getAll(int page, int pageSize, String status) {
        return this.usuarioDao.getAll(page, pageSize, status);
    }

    @Override
    public Usuario add(Usuario usuario) {
        return this.usuarioDao.add(usuario);
    }

    @Override
    public Usuario update(Usuario usuario) {
        return this.usuarioDao.update(usuario);
    }
}
