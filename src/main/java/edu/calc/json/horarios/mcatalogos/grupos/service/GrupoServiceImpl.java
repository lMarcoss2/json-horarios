package edu.calc.json.horarios.mcatalogos.grupos.service;

import com.google.gson.Gson;
import edu.calc.json.horarios.common.model.WrapperData;
import edu.calc.json.horarios.mcatalogos.grupos.model.Grupo;
import edu.calc.json.horarios.mcatalogos.grupos.model.ListGrupo;
import edu.calc.json.horarios.utils.UtilFile;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

/**
 * @author Marcos Santiago Leonardo
 * Universidad de la Sierra Sur (UNSIS)
 * Description:
 * Date: 3/26/19
 */
@Service
public class GrupoServiceImpl implements GrupoService {


    @Override
    public WrapperData getAllByStatus(int page, int pageSize, String status) {
        return null;
    }

    @Override
    public WrapperData getAllByStatusAndOneParam(int page, int pageSize, String status, String licenciatura) {
        return null;
    }

    @Override
    public Grupo add(Grupo grupo) {
        return null;
    }

    @Override
    public Grupo update(Grupo grupo) {
        return null;
    }

    @Override
    public List<Grupo> getAllByPeriodo(String periodo) throws IOException {
        Gson gson = new Gson();
        //JSON8
        ListGrupo listGrupo = gson.fromJson(UtilFile.readContentFile("grupos.json"), ListGrupo.class);
        return listGrupo.getGrupos();
    }
}
