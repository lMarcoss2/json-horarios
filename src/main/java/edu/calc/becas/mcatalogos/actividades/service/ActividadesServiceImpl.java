package edu.calc.becas.mcatalogos.actividades.service;

import edu.calc.becas.common.model.WrapperData;
import edu.calc.becas.mcatalogos.actividades.dao.ActividadesDao;
import edu.calc.becas.mcatalogos.actividades.model.ActividadVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ActividadesServiceImpl implements ActividadesService{

    private final ActividadesDao actividadesDao;

    @Autowired
    public ActividadesServiceImpl(ActividadesDao actividadesDao){this.actividadesDao = actividadesDao;}

    @Override
    public WrapperData getAll(int page, int pageSize, String status)
    {
        return actividadesDao.getAll(page,pageSize, status);
    }

    @Override
    public ActividadVo add(ActividadVo actividad) {
        return actividadesDao.add(actividad);
    }
}
