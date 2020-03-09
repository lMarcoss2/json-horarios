package edu.calc.json.horarios.mcatalogos.licenciaturas.service;

import com.google.gson.Gson;
import edu.calc.json.horarios.common.model.WrapperData;
import edu.calc.json.horarios.mcatalogos.licenciaturas.model.Licenciatura;
import edu.calc.json.horarios.mcatalogos.licenciaturas.model.ListCarreras;
import org.springframework.stereotype.Service;

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
    public List<Licenciatura> getAllVigentes() {
        return getLicenciaturas();
    }

    private List<Licenciatura> getLicenciaturas() {
        Gson gson = new Gson();
        //JSON5
        ListCarreras listCarreras = gson.fromJson("[{\"clave\":\"01B\",\"nombre\":\"LICENCIATURA EN ADMINISTRACIÓN MUNICIPAL 2015\",\"vigente\":true},{\"clave\":\"03\",\"nombre\":\"LICENCIATURA EN ENFERMERÍA 2012\",\"vigente\":true},{\"clave\":\"11\",\"nombre\":\"DOCTORADO EN GOBIERNO ELECTRÓNICO 2016\",\"vigente\":true},{\"clave\":\"10\",\"nombre\":\"MAESTRÍA EN GOBIERNO ELECTRÓNICO 2016\",\"vigente\":true},{\"clave\":\"09\",\"nombre\":\"MAESTRÍA EN SALUD PÚBLICA 2016\",\"vigente\":true},{\"clave\":\"08\",\"nombre\":\"MAESTRÍA EN PLANEACIÓN ESTRATÉGICA MUNICIPAL 2016\",\"vigente\":true},{\"clave\":\"07B\",\"nombre\":\"LICENCIATURA EN NUTRICIÓN 2017\",\"vigente\":true},{\"clave\":\"06\",\"nombre\":\"LICENCIATURA EN INFORMÁTICA\",\"vigente\":true},{\"clave\":\"05\",\"nombre\":\"LICENCIATURA EN ADMINISTRACIÓN PÚBLICA 2012\",\"vigente\":true},{\"clave\":\"04B\",\"nombre\":\"LICENCIATURA EN CIENCIAS EMPRESARIALES 2017\",\"vigente\":true},{\"clave\":\"12\",\"nombre\":\"INGLÉS\",\"vigente\":true},{\"clave\":\"07\",\"nombre\":\"LICENCIATURA EN NUTRICIÓN\",\"vigente\":true},{\"clave\":\"01\",\"nombre\":\"LICENCIATURA EN ADMINISTRACIÓN MUNICIPAL 2007\",\"vigente\":true},{\"clave\":\"04\",\"nombre\":\"LICENCIATURA EN CIENCIAS EMPRESARIALES\",\"vigente\":true},{\"clave\":\"03C\",\"nombre\":\"LICENCIATURA EN ENFERMERÍA 2018\",\"vigente\":true},{\"clave\":\"14\",\"nombre\":\"LICENCIATURA EN ODONTOLOGÍA 2017\",\"vigente\":true},{\"clave\":\"15\",\"nombre\":\"LICENCIATURA EN MEDICINA 2018\",\"vigente\":true}]", ListCarreras.class);
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
    public Licenciatura getDetalleCarrera(String clave) {
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
