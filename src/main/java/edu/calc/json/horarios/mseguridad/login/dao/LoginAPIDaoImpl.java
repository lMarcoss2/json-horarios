package edu.calc.json.horarios.mseguridad.login.dao;

import edu.calc.json.horarios.common.base.dao.BaseDao;
import edu.calc.json.horarios.exceptions.GenericException;
import edu.calc.json.horarios.mseguridad.rolesypermisos.model.Rol;
import edu.calc.json.horarios.mseguridad.usuarios.model.Usuario;
import edu.calc.json.horarios.mvc.config.MessageApplicationProperty;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class LoginAPIDaoImpl extends BaseDao implements LoginAPIDao {

    private final MessageApplicationProperty messageApplicationProperty;

    public LoginAPIDaoImpl(JdbcTemplate jdbcTemplate, MessageApplicationProperty messageApplicationProperty) {
        super(jdbcTemplate);
        this.messageApplicationProperty = messageApplicationProperty;
    }

    public Usuario login(String username, String password) throws GenericException {
        try {
            return jdbcTemplate.queryForObject(QueriesLogin.QRY_GET_INFO_LOGIN,
                    new Object[]{username, username},
                    (((rs, i) -> mapperLoginUser(rs))));
        } catch (EmptyResultDataAccessException e) {
            throw new GenericException(messageApplicationProperty.getUsuarioNoRegistrado());
        }

    }

    private Usuario mapperLoginUser(ResultSet rs) throws SQLException {
        Usuario usuario = new Usuario();
        Rol rol = new Rol();
        usuario.setIdUsuario(rs.getInt("ID_USUARIO"));
        usuario.setNombres(rs.getString("NOMBRES"));
        usuario.setApePaterno(rs.getString("APE_PATERNO"));
        usuario.setApeMaterno(rs.getString("APE_MATERNO"));
        usuario.setTipoUsuario(rs.getString("ID_ROL"));
        usuario.setUsername(rs.getString("USERNAME"));
        rol.setIdRol(rs.getInt("ID_ROL"));
        rol.setNombre(rs.getString("ROL"));
        usuario.setRol(rol);
        return usuario;
    }
}
