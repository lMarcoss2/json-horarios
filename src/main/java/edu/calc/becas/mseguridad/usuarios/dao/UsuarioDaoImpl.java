package edu.calc.becas.mseguridad.usuarios.dao;

import edu.calc.becas.common.base.dao.BaseDao;
import edu.calc.becas.common.model.WrapperData;
import edu.calc.becas.mseguridad.usuarios.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import static edu.calc.becas.common.utils.Constant.ESTATUS_DEFAULT;
import static edu.calc.becas.mseguridad.usuarios.dao.QueriesUsuario.*;

/**
 * @author Marcos Santiago Leonardo
 * Universidad de la Sierra Sur (UNSIS)
 * Description:
 * Date: 4/14/19
 */
@Repository
public class UsuarioDaoImpl extends BaseDao implements UsuarioDao {

    private final JdbcTemplate jdbcTemplate;
    private final String secretKeyStart = "4^%m@=C*&c#L+%";
    private final String secretKeyEnd = "U$|2AT>30!";

    @Autowired
    public UsuarioDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public WrapperData getAll(int page, int pageSize, String status) {
        String queryGetALl = QRY_GET_ALL;

        if (status != null && !status.equalsIgnoreCase(ESTATUS_DEFAULT)) {
            queryGetALl = queryGetALl.concat(QRY_CONDITION_ESTATUS.replace("?", "'" + status + "'"));

            int lengthDataTable = this.jdbcTemplate.queryForObject(QRY_COUNT_ITEM.concat(
                    QRY_CONDITION_ESTATUS.replace("?", "'" + status + "'")), Integer.class);
            List<Usuario> data = this.jdbcTemplate.query(queryGetALl, (rs, rowNum) -> mapperUsuario(rs));
            return new WrapperData(data, page, lengthDataTable, lengthDataTable);
        }

        int lengthDataTable = this.jdbcTemplate.queryForObject(QRY_COUNT_ITEM, Integer.class);
        List<Usuario> data = this.jdbcTemplate.query(queryGetALl.concat(createQueryPageable(page, pageSize)), (rs, rowNum) -> mapperUsuario(rs));
        return new WrapperData(data, page, pageSize, lengthDataTable);
    }

    private Usuario mapperUsuario(ResultSet rs) throws SQLException {
        Usuario usuario = new Usuario(rs.getString("ESTATUS"));
        usuario.setIdUsuario(rs.getInt("ID_USUARIO"));
        usuario.setNombres(rs.getString("NOMBRES"));
        usuario.setApePaterno(rs.getString("APE_PATERNO"));
        usuario.setApeMaterno(rs.getString("APE_MATERNO"));
        usuario.setTipoUsuario(rs.getString("TIPO_USUARIO"));
        usuario.setUsername(rs.getString("USERNAME"));
        return usuario;
    }

    @Override
    public Usuario add(Usuario usuario) {
        this.jdbcTemplate.update(QRY_ADD,
                usuario.getNombres().trim(), usuario.getApePaterno().trim(), usuario.getApeMaterno().trim(),
                usuario.getTipoUsuario().trim(), usuario.getUsername().trim(),
                secretKeyStart, usuario.getPassword(), secretKeyEnd,
                usuario.getEstatus().trim(), usuario.getAgregadoPor().trim());
        return usuario;
    }

    @Override
    public Usuario update(Usuario usuario) {
        String password = usuario.getPassword();
        if (password != null && !password.equalsIgnoreCase("")) {
            this.jdbcTemplate.update(QRY_UPDATE_WITH_PASSWORD, usuario.getNombres().trim(), usuario.getApePaterno().trim(), usuario.getApeMaterno().trim(),
                    usuario.getTipoUsuario().trim(), usuario.getUsername().trim(), secretKeyStart, usuario.getPassword(), secretKeyEnd, usuario.getEstatus().trim(), usuario.getActualizadoPor().trim());
        } else {
            this.jdbcTemplate.update(QRY_UPDATE, usuario.getNombres().trim(), usuario.getApePaterno().trim(), usuario.getApeMaterno().trim(),
                    usuario.getTipoUsuario().trim(), usuario.getUsername().trim(), usuario.getEstatus().trim(), usuario.getActualizadoPor().trim(), usuario.getIdUsuario());
        }

        return usuario;
    }
}
