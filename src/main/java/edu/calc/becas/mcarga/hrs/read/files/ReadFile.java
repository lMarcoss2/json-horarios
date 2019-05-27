package edu.calc.becas.mcarga.hrs.read.files;

import edu.calc.becas.exceptions.GenericException;
import edu.calc.becas.malumnos.model.Alumno;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Marcos Santiago Leonardo
 * Universidad de la Sierra Sur (UNSIS)
 * Description:
 * Date: 5/13/19
 */
public class ReadFile {
    private static final Logger LOG = LoggerFactory.getLogger(ReadFile.class);

    private static final int posMatricula = 1;
    private static final int posNombre = 2;
    private static final int posHrs = 3;
    private static final int posEndCell = 4;

    public static void readFile(String pathfile) throws GenericException {
        Workbook workbook = null;
        try {
            workbook = WorkbookFactory.create(new File(pathfile));
        } catch (IOException | InvalidFormatException e) {
            e.printStackTrace();
            throw new GenericException(e);
        }

        System.out.println("SHEETS: " + workbook.getNumberOfSheets());


        // Leer hojas o sábanas del excel
        for (Sheet sheet : workbook) {
            System.out.println(sheet.getSheetName());
        }

        // leer primer hoja
        Sheet sheet = workbook.getSheetAt(0);

        // filas de una hola
        List<RowFile> rows = new ArrayList<>();
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
                    alumno.setHrs(row.getCells().get(i).getValue());
                }
            }
            alumnos.add(alumno);
        }

        /*List<RowFile> rowFiles = new ArrayList<>();
        for (RowFile row : rows) {
            List<CellFile> cellFiles = row.getCells();
            if (cellFiles != null && !cellFiles.isEmpty()) {
                if (cellFiles.size() > 8) {
                    RowFile rowFile = new RowFile();
                    rowFile.setCells(cellFiles);

                    rowFiles.add(rowFile);
                }

            }


        }*/
        for (Alumno alumno : alumnos) {
            LOG.info(alumno.getMatricula() + " : " + alumno.getNombres() + " : " + alumno.getHrs());
        }
    }

    private static String readCellByType(Cell cell) {
        String value = null;
        try {
            switch (cell.getCellTypeEnum()) {
                case NUMERIC:
                    /*System.out.println("NUMERIC");
                    System.out.println(cell.getNumericCellValue());*/
                    value = String.valueOf(cell.getNumericCellValue());
                    break;
                case BOOLEAN:
                    /*System.out.println("BOOLEAN");
                    System.out.println(cell.getBooleanCellValue());*/
                    value = String.valueOf(cell.getBooleanCellValue());
                    break;
                case STRING:
                    /*System.out.println("STRING");
                    System.out.println(cell.getRichStringCellValue());*/
                    value = String.valueOf(cell.getRichStringCellValue());
                    break;
                case FORMULA:
                    /*System.out.println("FORMULA");
                    System.out.println(cell.getCellFormula());*/
                    value = cell.getCellFormula();
                    break;
                case BLANK:
                    System.out.println("BLANK");
                    System.out.println();
                    break;
                case _NONE:
                    System.out.println("_NONE");
                    break;
                default:
                    System.out.println("default");

            }
            return value;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
