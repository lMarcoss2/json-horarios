package edu.calc.becas.mcatalogos.grupos.dao;

import edu.calc.becas.common.base.dao.BaseDao;
import edu.calc.becas.common.model.WrapperData;
import edu.calc.becas.mcatalogos.grupos.model.Grupo;
import edu.calc.becas.mcatalogos.licenciaturas.model.Licenciatura;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static edu.calc.becas.common.utils.Constant.ESTATUS_DEFAULT;
import static edu.calc.becas.common.utils.Constant.ITEMS_FOR_PAGE;
import static edu.calc.becas.common.utils.Constant.LICENCIATURA_DEFAULT;
import static edu.calc.becas.mcatalogos.grupos.dao.QueriesGrupo.*;


/**
 * @author Marcos Santiago Leonardo
 * Universidad de la Sierra Sur (UNSIS)
 * Description: group Repository
 * Date: 3/26/19
 */
@Repository
public class GrupoDaoImpl extends BaseDao implements GrupoDao {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public GrupoDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public WrapperData getAll(int page, int pageSize, String status, String licenciatura) {

        boolean pageable = pageSize != Integer.parseInt(ITEMS_FOR_PAGE);
        boolean byStatus = !status.equalsIgnoreCase(ESTATUS_DEFAULT);
        boolean byLicenciatura = !licenciatura.equalsIgnoreCase(LICENCIATURA_DEFAULT);


        String queryGetALl = QRY_GET_ALL;
        String queryCountItem = QRY_COUNT_ITEM;

        if (byStatus) {
            queryGetALl = queryGetALl.concat(QRY_CONDITION_ESTATUS.replace("?", "'" + status + "'"));
            queryCountItem = queryCountItem.concat(QRY_CONDITION_ESTATUS.replace("?", "'" + status + "'"));
        }

        if (byLicenciatura) {
            queryGetALl = queryGetALl.concat(QRY_CONDITION_ID_LICENCIATURA.replace("?", "'" + licenciatura + "'"));
            queryCountItem = queryCountItem.concat(QRY_CONDITION_ID_LICENCIATURA.replace("?", "'" + licenciatura + "'"));
        }

        queryGetALl = queryGetALl.concat(QRY_ORDER_BY);

        if (pageable) {
            queryGetALl = queryGetALl.concat(createQueryPageable(page, pageSize));
        }


        int lengthDataTable = this.jdbcTemplate.queryForObject(queryCountItem, Integer.class);

        List<Grupo> data = this.jdbcTemplate.query(queryGetALl, (rs, rowNum) -> mapperGrupo(rs));

        if (!pageable) {
            page = 0;
            pageSize = lengthDataTable;
        }
        return new WrapperData(data, page, pageSize, lengthDataTable);
    }


    private Grupo getByAllAttributes(Grupo grupo) {
        String query = QRY_GET_ALL;
        List params = new ArrayList();
        if (grupo.getIdGrupo() > 0) {
            query = query.concat(QRY_CONDITION_ID_GRUPO);
            params.add(grupo.getIdGrupo());
        }

        if (grupo.getCveGrupo() != null && !grupo.getCveGrupo().equalsIgnoreCase("")) {
            query = query.concat(QRY_CONDITION_CVE_GRUPO);
            params.add(grupo.getCveGrupo());
        }

        if (grupo.getLicenciatura().getIdLicenciatura() > 0) {
            query = query.concat(QRY_CONDITION_ID_LICENCIATURA);
            params.add(grupo.getLicenciatura().getIdLicenciatura());
        }

        if (grupo.getEstatus() != null && !grupo.getEstatus().equalsIgnoreCase("")) {
            query = query.concat(QRY_CONDITION_ESTATUS);
            params.add(grupo.getEstatus());
        }

        if (grupo.getAgregadoPor() != null && !grupo.getAgregadoPor().equalsIgnoreCase("")) {
            query = query.concat(QRY_CONDITION_AGREGADO_POR);
            params.add(grupo.getAgregadoPor());
        }

        if (grupo.getActualizadoPor() != null && !grupo.getActualizadoPor().equalsIgnoreCase("")) {
            query = query.concat(QRY_CONDITION_ACTUALIZADO_POR);
            params.add(grupo.getActualizadoPor());
        }

        return jdbcTemplate.queryForObject(query, params.toArray(), (rs, i) -> mapperGrupo(rs));
    }

    @Override
    public Grupo add(Grupo grupo) {
        this.jdbcTemplate.update(QRY_ADD, createParamInsert(grupo));
        return grupo;
    }

    private Object[] createParamInsert(Grupo grupo) {
        return new Object[]{
                grupo.getCveGrupo(),
                grupo.getLicenciatura().getIdLicenciatura(),
                grupo.getEstatus(),
                grupo.getAgregadoPor()
        };
    }


    @Override
    public Grupo update(Grupo grupo) {
        this.jdbcTemplate.update(QRY_UPDATE, createParamUpdate(grupo));
        return grupo;
    }

    private Object[] createParamUpdate(Grupo grupo) {
        return new Object[]{
                grupo.getCveGrupo(),
                grupo.getLicenciatura().getIdLicenciatura(),
                grupo.getEstatus(),
                grupo.getActualizadoPor(),
                grupo.getIdGrupo()
        };
    }

    private Grupo mapperGrupo(ResultSet rs) throws SQLException {
        Grupo grupo = new Grupo(rs.getString("ESTATUS"));
        Licenciatura lic = new Licenciatura();
        grupo.setIdGrupo(rs.getInt("ID_GRUPO"));
        grupo.setCveGrupo(rs.getString("CVE_GRUPO"));
        lic.setIdLicenciatura(rs.getInt("ID_LICENCIATURA"));
        lic.setNombreLicenciatura(rs.getString("NOMBRE_LICENCIATURA"));
        grupo.setLicenciatura(lic);
        return grupo;
    }
}
