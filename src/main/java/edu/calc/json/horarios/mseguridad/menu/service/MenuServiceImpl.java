package edu.calc.json.horarios.mseguridad.menu.service;

import edu.calc.json.horarios.exceptions.GenericException;
import edu.calc.json.horarios.mseguridad.menu.dao.MenuDao;
import edu.calc.json.horarios.mseguridad.menu.model.Menu;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuServiceImpl implements MenuService {
    private final MenuDao menuDao;

    public MenuServiceImpl(MenuDao menuDao) {
        this.menuDao = menuDao;
    }

    @Override
    public List<Menu> getMenu(String username) throws GenericException {
        return menuDao.getMenu(username);
    }
}
