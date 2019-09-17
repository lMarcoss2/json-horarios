package edu.calc.becas.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public final class UtilDate {
    public static String PATTERN_GUION = "dd-MM-yyyy";
    public static String PATTERN_DIAG = "dd/MM/yyyy";
    private UtilDate() {
    }

    /**
     * @param fecha
     * @param daysSum
     * @return suma días a una fecha
     */
    public static Date getNextDayBySum(Date fecha, int daysSum) {
        Calendar c = Calendar.getInstance();
        c.setTime(fecha);
        c.add(Calendar.DATE, daysSum);
        return (Date) c.getTime().clone();
    }

    /**
     * @param fecha
     * @return convierte una fecha dd/MM/yyyy a fecha Date
     * @throws Exception
     */
    public static Date convertToDate(String fecha) throws Exception {
        SimpleDateFormat sdfrmt = new SimpleDateFormat("dd-MM-yyyy");
        sdfrmt.setLenient(false);
        try {
            return sdfrmt.parse(fecha);
        } catch (ParseException e) {
            throw new Exception(e);
        }
    }

    /**
     * @param fecha
     * @return convierte una fecha DAte a string dd/MM/yyyy
     */
    public static String convertDateToString(Date fecha, String pattern) {
        SimpleDateFormat formato = new SimpleDateFormat(pattern);
        return formato.format(fecha);
    }
}
