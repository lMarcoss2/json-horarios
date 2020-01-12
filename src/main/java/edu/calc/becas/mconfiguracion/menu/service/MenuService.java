package edu.calc.becas.mconfiguracion.menu.service;

import edu.calc.becas.exceptions.GenericException;
import edu.calc.becas.mconfiguracion.menu.model.Menu;

import java.util.List;

public interface MenuService {
    List<Menu> getMenu(String username) throws GenericException;
}
