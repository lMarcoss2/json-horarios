package edu.calc.becas.mcatalogos.licenciaturas.service;

import edu.calc.becas.common.model.WrapperData;
import edu.calc.becas.mcatalogos.licenciaturas.model.Licenciatura;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
        return getLicenciaturas();
    }

    private WrapperData getLicenciaturas() {
        WrapperData<Licenciatura> wrapperData = new WrapperData<>();
        List<Licenciatura> licenciaturas = new ArrayList<>();


            licenciaturas.add(createLic(
            "01B",
                "LICENCIATURA EN ADMINISTRACIÓN MUNICIPAL 2015",
                true));
            licenciaturas.add(createLic(
            "03",
                "LICENCIATURA EN ENFERMERÍA 2012",
                true));
            licenciaturas.add(createLic(
            "11",
                "DOCTORADO EN GOBIERNO ELECTRÓNICO 2016",
                true));
            licenciaturas.add(createLic(
            "10",
                "MAESTRÍA EN GOBIERNO ELECTRÓNICO 2016",
                true));
            licenciaturas.add(createLic(
            "09",
                "MAESTRÍA EN SALUD PÚBLICA 2016",
                true));
            licenciaturas.add(createLic(
            "08",
                "MAESTRÍA EN PLANEACIÓN ESTRATÉGICA MUNICIPAL 2016",
                true));
            licenciaturas.add(createLic(
            "07B",
                "LICENCIATURA EN NUTRICIÓN 2017",
                true));
            licenciaturas.add(createLic(
            "06",
                "LICENCIATURA EN INFORMÁTICA",
                true));
            licenciaturas.add(createLic(
            "05",
                "LICENCIATURA EN ADMINISTRACIÓN PÚBLICA 2012",
                true));
            licenciaturas.add(createLic(
            "04B",
                "LICENCIATURA EN CIENCIAS EMPRESARIALES 2017",
                true));
            licenciaturas.add(createLic(
            "12",
                "INGLÉS",
                true));
            licenciaturas.add(createLic(
            "07",
                "LICENCIATURA EN NUTRICIÓN",
                true));
            licenciaturas.add(createLic(
            "01",
                "LICENCIATURA EN ADMINISTRACIÓN MUNICIPAL 2007",
                true));
            licenciaturas.add(createLic(
            "04",
                "LICENCIATURA EN CIENCIAS EMPRESARIALES",
                true));
            licenciaturas.add(createLic(
            "03C",
                "LICENCIATURA EN ENFERMERÍA 2018",
                true));
            licenciaturas.add(createLic(
            "14",
                "LICENCIATURA EN ODONTOLOGÍA 2017",
                true));
            licenciaturas.add(createLic(
            "15",
                "LICENCIATURA EN MEDICINA 2018",
                true));



        wrapperData.setPage(0);
        wrapperData.setPageSize(licenciaturas.size());
        wrapperData.setLengthData(licenciaturas.size());
        wrapperData.setData(licenciaturas);
        return wrapperData;
    }

    private Licenciatura createLic(String cveLic, String nombreLic, boolean vigente) {
        Licenciatura lic = new Licenciatura();
        lic.setCveLicenciatura(cveLic);
        lic.setNombreLicenciatura(nombreLic);
        lic.setVigente(vigente);

        return lic;
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
}
