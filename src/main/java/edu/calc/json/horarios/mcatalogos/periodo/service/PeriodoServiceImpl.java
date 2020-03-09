package edu.calc.json.horarios.mcatalogos.periodo.service;

import com.google.gson.Gson;
import edu.calc.json.horarios.common.model.WrapperData;
import edu.calc.json.horarios.mcatalogos.periodo.model.Periodo;
import org.springframework.stereotype.Service;

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
    public Periodo getCicloEscolarActual() {

        //JSON2
        Gson gson = new Gson();
        Periodo periodo = gson.fromJson("{\"clave\":\"1819B\",\"nombre\":\"SEM-MAR/19-JUN/19\",\"tipo\":\"B\",\"fInicio\":\"2019-03-04\",\"fFin\":\"2019-07-28\"}", Periodo.class);
        return periodo;
    }
}


