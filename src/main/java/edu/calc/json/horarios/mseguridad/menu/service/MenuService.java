package edu.calc.json.horarios.mseguridad.menu.service;

import edu.calc.json.horarios.exceptions.GenericException;
import edu.calc.json.horarios.mseguridad.menu.model.Menu;

import java.util.List;

public interface MenuService {
    List<Menu> getMenu(String username) throws GenericException;
}
