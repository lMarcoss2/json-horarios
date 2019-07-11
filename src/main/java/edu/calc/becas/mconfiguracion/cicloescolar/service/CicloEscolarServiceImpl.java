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
    public WrapperData getAllByStatus(int page, int pageSize, String status) {
        return cicloEscolarDao.getAllByStatus(page,pageSize, status);
    }

    @Override
    public WrapperData getAllByStatusAndOneParam(int page, int pageSize, String status, String param1) {
        return null;
    }

    @Override
    public CicloEscolarVo add(CicloEscolarVo ciclo) {
        return cicloEscolarDao.add(ciclo);
    }

    @Override
    public CicloEscolarVo update(CicloEscolarVo cicloEscolarVo) {
        return cicloEscolarDao.update(cicloEscolarVo);
    }

    @Override
    public List<LabelValueData> getListCatalog() {
        return cicloEscolarDao.getListCatalog();
    }


}
