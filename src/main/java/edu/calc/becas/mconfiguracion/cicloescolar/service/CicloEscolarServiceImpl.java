package edu.calc.becas.mconfiguracion.cicloescolar.service;

import edu.calc.becas.common.model.WrapperData;
import edu.calc.becas.mconfiguracion.cicloescolar.dao.CicloEscolarDao;
import edu.calc.becas.mconfiguracion.cicloescolar.dao.CicloEscolarDaoImpl;
import edu.calc.becas.mconfiguracion.cicloescolar.model.CicloEscolarVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
