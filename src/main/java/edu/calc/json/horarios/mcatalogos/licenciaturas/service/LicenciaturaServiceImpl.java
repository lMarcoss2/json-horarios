package edu.calc.json.horarios.mcatalogos.licenciaturas.service;

import com.google.gson.Gson;
import edu.calc.json.horarios.common.model.WrapperData;
import edu.calc.json.horarios.mcatalogos.licenciaturas.model.Licenciatura;
import edu.calc.json.horarios.mcatalogos.licenciaturas.model.ListCarreras;
import edu.calc.json.horarios.utils.UtilFile;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

/**
 * @author Marcos Santiago Leonardo
 * Universidad de la Sierra Sur (UNSIS)
 * Description:
 * Date: 3/23/19
 */
@Service
public class LicenciaturaServiceImpl implements LicenciaturaService {


    @Override
    public WrapperData getAllByStatus(int page, int pageSize, String status) {
        return null;
    }


    @Override
    public List<Licenciatura> getAllVigentes() throws Exception {
        return getLicenciaturas();
    }

    private List<Licenciatura> getLicenciaturas() throws Exception {
        Gson gson = new Gson();
        //JSON5
        ListCarreras listCarreras = null;
        try {
            listCarreras = gson.fromJson(UtilFile.readContentFile("licenciaturas.json"), ListCarreras.class);
        } catch (IOException e) {
            throw new Exception("Error al leer el  archivo licenciaturas.json " +  e.getMessage());
        }
        return listCarreras.getLicenciaturas();
    }


    @Override
    public WrapperData getAllByStatusAndOneParam(int page, int pageSize, String status, String param1) {
        return null;
    }

    @Override
    public Licenciatura add(Licenciatura lic) {
        return null;
    }

    @Override
    public Licenciatura update(Licenciatura lic) {
        return null;
    }

    @Override
    public Licenciatura getDetalleCarrera(String clave) throws Exception {
        //JSON6
        List<Licenciatura> licenciaturas = this.getLicenciaturas();
        Licenciatura licenciatura1 = null;
        for (Licenciatura licenciatura : licenciaturas) {
            if (licenciatura.getClave().equalsIgnoreCase(clave)) {
                licenciatura1 = licenciatura;
            }
        }
        return licenciatura1;
    }
}
