package edu.calc.json.horarios.mseguridad.menu.dao;

import edu.calc.json.horarios.exceptions.GenericException;
import edu.calc.json.horarios.mseguridad.menu.model.Menu;

import java.util.List;

public interface MenuDao {
    List<Menu> getMenu(String username) throws GenericException;
}
