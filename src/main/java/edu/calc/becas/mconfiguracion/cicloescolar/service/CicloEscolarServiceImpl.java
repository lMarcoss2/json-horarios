package edu.calc.becas.mconfiguracion.cicloescolar.service;

import edu.calc.becas.common.model.WrapperData;
import edu.calc.becas.exceptions.GenericException;
import edu.calc.becas.mconfiguracion.cicloescolar.model.CicloEscolarVo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CicloEscolarServiceImpl implements CicloEscolarService {


    @Override
    public WrapperData getAllByStatus(int page, int pageSize, String status) {
        WrapperData<CicloEscolarVo> wrapperData = new WrapperData<>();

        List<CicloEscolarVo> ciclos = new ArrayList<>();

        ciclos.add(createCicloEscolar("1819B", "SEM-MAR/19-JUN/19", "B", "2019-03-04", "2019-07-28"));

        wrapperData.setData(ciclos);
        wrapperData.setPage(0);
        wrapperData.setPageSize(ciclos.size());
        wrapperData.setLengthData(ciclos.size());
        return wrapperData;
    }

    private CicloEscolarVo createCicloEscolar(String clave, String nombre, String tipo, String fechaInicio, String fechaFin) {
        CicloEscolarVo ciclo = new CicloEscolarVo();
        ciclo.setClave(clave);
        ciclo.setNombre(nombre);
        ciclo.setTipo(tipo);
        ciclo.setFechaInicio(fechaInicio);
        ciclo.setFechaFin(fechaFin);
        return ciclo;
    }

    @Override
    public WrapperData getAllByStatusAndOneParam(int page, int pageSize, String status, String param1) {
        return null;
    }

    @Override
    public CicloEscolarVo add(CicloEscolarVo ciclo) {
        return null;
    }

    @Override
    public CicloEscolarVo update(CicloEscolarVo cicloEscolarVo) {
        return null;
    }


    @Override
    public CicloEscolarVo getParcialActual() throws Exception {
        WrapperData<CicloEscolarVo> ciclos = this.getAllByStatus(0, 0, null);
        if (ciclos != null && ciclos.getData() != null && !ciclos.getData().isEmpty()) {
            return ciclos.getData().get(0);
        }
        throw new Exception("No hay datos de periodo escolar actual");
    }

    @Override
    public CicloEscolarVo getCicloEscolarActual() throws GenericException {
        try {
            return createCicloEscolar("1819B", "SEM-MAR/19-JUN/19", "B", "2019-03-04", "2019-07-28");
        } catch (Exception e) {
            throw new GenericException("Ciclo escolar no encontrado o el servicio de recuperación falló");
        }

    }

}
