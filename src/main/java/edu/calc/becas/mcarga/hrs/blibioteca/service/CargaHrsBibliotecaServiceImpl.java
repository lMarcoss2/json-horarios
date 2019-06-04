package edu.calc.becas.mcarga.hrs.blibioteca.service;

import edu.calc.becas.malumnos.model.Alumno;
import edu.calc.becas.malumnos.model.Hora;
import edu.calc.becas.mcarga.hrs.CargaHrsDao;
import edu.calc.becas.mcarga.hrs.ProcessHoursService;
import edu.calc.becas.mcarga.hrs.ProcessRow;
import edu.calc.becas.mcarga.hrs.read.files.model.RowFile;
import org.apache.poi.ss.usermodel.Workbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Marcos Santiago Leonardo
 * Universidad de la Sierra Sur (UNSIS)
 * Description:
 * Date: 5/13/19
 */
@Service("cargaHrsBibliotecaService")
public class CargaHrsBibliotecaServiceImpl extends ProcessRow implements ProcessHoursService {
    private static final Logger LOG = LoggerFactory.getLogger(CargaHrsBibliotecaServiceImpl.class);

    private static final int posMatricula = 1;
    private static final int posNombre = 2;
    private static final int posHrs = 3;
    private static final int posEndCell = 4;

    private final CargaHrsDao cargaHrsBibliotecaDao;

    @Autowired
    public CargaHrsBibliotecaServiceImpl(@Qualifier("cargaHrsBibliotecaRepository") CargaHrsDao cargaHrsBibliotecaDao) {
        this.cargaHrsBibliotecaDao = cargaHrsBibliotecaDao;
    }


    @Override
    public void processData(Workbook pages) {
        List<RowFile> rows = readRows(pages);
        /*for (Sheet sheet : pages) {
            LOG.info("HOJA:  " + sheet.getSheetName());
            // filas de una hola
            for (Row row : sheet) {

                RowFile rowFile = new RowFile();

                List<CellFile> cells = new ArrayList<>();

                for (Cell cell : row) {
                    CellFile cellFile = new CellFile();
                    String value = readCellByType(cell);
                    if (value != null && !value.trim().equalsIgnoreCase("") && value.length() > 0) {
                        cellFile.setValue(
                                value.trim()
                        );

                        cells.add(cellFile);
                    }


                }
                if (!cells.isEmpty() && cells.size() > 8) {
                    rowFile.setCells(cells);
                    rows.add(rowFile);
                }

            }
        }*/

        List<Alumno> alumnos = new ArrayList<>();
        for (RowFile row : rows) {
            Alumno alumno = new Alumno();
            for (int i = 0; i < posEndCell; i++) {
                if (i == posMatricula) {
                    alumno.setMatricula(row.getCells().get(i).getValue());
                }

                if (i == posNombre) {
                    alumno.setNombres(row.getCells().get(i).getValue());
                }

                if (i == posHrs) {
                    try {
                        String hrs = row.getCells().get(i).getValue();
                        String[] horas = hrs.split(":");
                        Hora hora = new Hora();
                        if (horas.length == 2) {
                            hora.setNumHora(Integer.parseInt(horas[0]));
                            hora.setNumMinutos(Integer.parseInt(horas[1]));
                        } else if (horas.length == 1) {
                            hora.setNumHora(Integer.parseInt(horas[0]));
                            hora.setNumMinutos(0);
                        }
                        alumno.setHora(hora);
                    } catch (Exception e) {
                        LOG.error("ERROR AL OBTENER NÚMERO DE HORAS");
                        LOG.error(Arrays.toString(e.getStackTrace()));
                    }
                }
            }
            alumnos.add(alumno);
        }

        this.cargaHrsBibliotecaDao.persistenceHours(alumnos);
    }
}
