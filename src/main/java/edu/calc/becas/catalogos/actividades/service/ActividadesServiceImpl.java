package edu.calc.becas.catalogos.actividades.service;

import edu.calc.becas.catalogos.actividades.dao.ActividadesDao;
import edu.calc.becas.common.model.WrapperData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ActividadesServiceImpl implements ActividadesService{

    private final ActividadesDao actividadesDao;

    @Autowired
    public ActividadesServiceImpl(ActividadesDao actividadesDao){this.actividadesDao = actividadesDao;}

    @Override
    public WrapperData getAll(int page, int pageSize) {
        return actividadesDao.getAll(page,pageSize);
    }
}
