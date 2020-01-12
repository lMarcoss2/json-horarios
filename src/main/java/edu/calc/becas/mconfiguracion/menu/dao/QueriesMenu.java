package edu.calc.becas.mconfiguracion.menu.dao;

final class QueriesMenu {
    private QueriesMenu() {
    }

    public static final String QRY_GET_PARENTS_BY_USER = "SELECT ID_MENU, ID_PADRE, NOMBRE, ICON, URL FROM MENU WHERE ID_MENU = ID_PADRE";
    public static final String QRY_GET_CHLIDS_BY_PARENT = "SELECT ID_MENU, ID_PADRE, NOMBRE, URL FROM MENU WHERE ID_PADRE = ? AND ID_MENU != ID_PADRE";
}
