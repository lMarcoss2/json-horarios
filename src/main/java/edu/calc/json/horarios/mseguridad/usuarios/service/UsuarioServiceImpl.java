package edu.calc.json.horarios.mseguridad.usuarios.service;

import edu.calc.json.horarios.common.model.WrapperData;
import edu.calc.json.horarios.mseguridad.usuarios.dao.UsuarioDao;
import edu.calc.json.horarios.mseguridad.usuarios.model.Usuario;
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
    public WrapperData getAllByStatus(int page, int pageSize, String status) {
        return null;
    }

    @Override
    public WrapperData getAllByStatusAndOneParam(int page, int pageSize, String status, String tipoUsuario) {
        return this.usuarioDao.getAllByStatusAndOneParam(page, pageSize, status, tipoUsuario);
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
