package edu.calc.becas.mconfiguracion.menu.dao;

import edu.calc.becas.exceptions.GenericException;
import edu.calc.becas.mconfiguracion.menu.model.Menu;

import java.util.List;

public interface MenuDao {
    List<Menu> getMenu(String username) throws GenericException;
}
