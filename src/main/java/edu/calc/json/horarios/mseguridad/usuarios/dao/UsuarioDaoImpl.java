package edu.calc.json.horarios.mseguridad.usuarios.dao;

import edu.calc.json.horarios.common.base.dao.BaseDao;
import edu.calc.json.horarios.common.model.WrapperData;
import edu.calc.json.horarios.mseguridad.usuarios.model.Usuario;
import edu.calc.json.horarios.common.utils.Constant;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import static edu.calc.json.horarios.mseguridad.usuarios.dao.QueriesUsuario.*;

/**
 * @author Marcos Santiago Leonardo
 * Universidad de la Sierra Sur (UNSIS)
 * Description:
 * Date: 4/14/19
 */
@Repository
public class UsuarioDaoImpl extends BaseDao implements UsuarioDao {

    private final String secretKeyStart = "4^%m@=C*&c#L+%";
    private final String secretKeyEnd = "U$|2AT>30!";

    public UsuarioDaoImpl(JdbcTemplate jdbcTemplate) {
        super(jdbcTemplate);
    }

    @Override
    public WrapperData getAllByStatus(int page, int pageSize, String status) {
        return null;
    }

    @Override
    public WrapperData getAllByStatusAndOneParam(int page, int pageSize, String status, String tipoUsuario) {

        boolean pageable = pageSize != Integer.parseInt(Constant.ITEMS_FOR_PAGE);
        boolean byTipoUsuario = !tipoUsuario.equalsIgnoreCase(Constant.TIPO_USUARIO_DEFAULT);

        String queryGetALl = addConditionFilterByStatus(status, QRY_GET_ALL, QRY_CONDITION_ESTATUS);

        if (byTipoUsuario) {
            queryGetALl = queryGetALl.concat(QRY_CONDITION_TIPO_USUARIO.replace("?", "'" + tipoUsuario + "'"));
        }

        queryGetALl = queryGetALl.concat(QRY_ORDER_BY);

        queryGetALl = addQueryPageable(page, pageSize, queryGetALl);

        int lengthDataTable = this.jdbcTemplate.queryForObject(createQueryCountItem(queryGetALl), Integer.class);

        List<Usuario> data = this.jdbcTemplate.query(queryGetALl, (rs, rowNum) -> mapperUsuario(rs));

        if (!pageable) {
            page = 0;
            pageSize = lengthDataTable;
        }
        return new WrapperData(data, page, pageSize, lengthDataTable);
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
}
