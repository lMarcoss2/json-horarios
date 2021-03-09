package edu.calc.json.horarios.utils;

import java.io.*;

/**
 * @author Marcos Santiago Leonardo
 * Seguros Sura
 * 08/03/21
 */
public class UtilFile {

    /**
     * Lee el contenido de un archivo
     *
     * @param pathFile
     * @return
     * @throws IOException
     */
    public static String readContentFile(String pathFile) throws IOException {
        /*InputStream resource = new ClassPathResource( "data/employees.dat").getInputStream();
        FileInputStream fis = new FileInputStream(pathFile);*/
        InputStream inputStream = UtilFile.class.getClassLoader().getResourceAsStream(pathFile);

        try (BufferedReader br = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"))) {
            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = br.readLine()) != null) {
                sb.append(line);
                sb.append('\n');
            }
            return sb.toString().trim();
        }
    }
}
