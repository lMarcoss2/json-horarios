package edu.calc.json.horarios.mcatalogos.periodo.service;

import com.google.gson.Gson;
import edu.calc.json.horarios.common.model.WrapperData;
import edu.calc.json.horarios.mcatalogos.periodo.model.Periodo;
import edu.calc.json.horarios.utils.UtilFile;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class PeriodoServiceImpl implements PeriodoService {


    @Override
    public WrapperData getAllByStatus(int page, int pageSize, String status) {

        return null;
    }


    @Override
    public WrapperData getAllByStatusAndOneParam(int page, int pageSize, String status, String param1) {
        return null;
    }

    @Override
    public Periodo add(Periodo ciclo) {
        return null;
    }

    @Override
    public Periodo update(Periodo periodo) {
        return null;
    }

    @Override
    public Periodo getCicloEscolarActual() throws Exception {

        //JSON2
        Gson gson = new Gson();
        Periodo periodo = null;
        try {
            periodo = gson.fromJson(UtilFile.readContentFile("periodo.json"), Periodo.class);
        } catch (IOException e) {
            throw new Exception("Error al leer el  archivo periodo.json " +  e.getMessage());
        }
        return periodo;
    }
}


