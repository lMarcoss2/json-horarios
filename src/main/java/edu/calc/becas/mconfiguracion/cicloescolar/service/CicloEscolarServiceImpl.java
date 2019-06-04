package edu.calc.becas.mconfiguracion.cicloescolar.service;

import edu.calc.becas.common.model.LabelValueData;
import edu.calc.becas.common.model.WrapperData;
import edu.calc.becas.mconfiguracion.cicloescolar.dao.CicloEscolarDao;
import edu.calc.becas.mconfiguracion.cicloescolar.model.CicloEscolarVo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CicloEscolarServiceImpl implements CicloEscolarService{


    CicloEscolarDao cicloEscolarDao;

    public CicloEscolarServiceImpl(CicloEscolarDao cicloEscolarDao){this.cicloEscolarDao = cicloEscolarDao;}

    @Override
    public WrapperData getAll(int page, int pageSize) {
        return cicloEscolarDao.getAll(page,pageSize);
    }

    @Override
    public CicloEscolarVo add(CicloEscolarVo ciclo) {
        return cicloEscolarDao.add(ciclo);
    }

    @Override
    public List<LabelValueData> getListCatalog() {
        return cicloEscolarDao.getListCatalog();
    }


}
