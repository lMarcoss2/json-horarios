package edu.calc.json.horarios.mcarga.hrs;

import edu.calc.json.horarios.common.model.CommonData;
import edu.calc.json.horarios.exceptions.GenericException;
import edu.calc.json.horarios.mconfiguracion.cicloescolar.model.CicloEscolarVo;
import edu.calc.json.horarios.mconfiguracion.parciales.model.Parcial;
import org.apache.poi.ss.usermodel.Workbook;


/**
 * @author Marcos Santiago Leonardo
 * Universidad de la Sierra Sur (UNSIS)
 * Description:
 * Date: 5/13/19
 */
public interface ProcessHoursService {
    int processData(Workbook pages, CommonData commonData, Parcial parcialActual, CicloEscolarVo cicloEscolarActual) throws GenericException;
}
