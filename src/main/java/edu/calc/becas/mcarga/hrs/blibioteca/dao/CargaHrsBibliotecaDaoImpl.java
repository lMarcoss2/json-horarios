package edu.calc.becas.mcarga.hrs.blibioteca.dao;

import edu.calc.becas.malumnos.model.Alumno;
import edu.calc.becas.mcarga.hrs.CargaHrsDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Marcos Santiago Leonardo
 * Universidad de la Sierra Sur (UNSIS)
 * Description:
 * Date: 6/3/19
 */
@Repository("cargaHrsBibliotecaRepository")
public class CargaHrsBibliotecaDaoImpl implements CargaHrsDao {
    private static final Logger LOG = LoggerFactory.getLogger(CargaHrsBibliotecaDaoImpl.class);

    @Override
    public void persistenceHours(List<Alumno> alumnos) {
        for (Alumno alumno : alumnos) {
            LOG.info(alumno.toString());
        }
    }
}
