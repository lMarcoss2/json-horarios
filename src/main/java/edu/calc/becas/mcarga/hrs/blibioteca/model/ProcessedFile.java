package edu.calc.becas.mcarga.hrs.blibioteca.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Marcos Santiago Leonardo
 * Universidad de la Sierra Sur (UNSIS)
 * Description:
 * Date: 5/4/19
 */
@Builder
@Getter
@Setter
public class ProcessedFile {
    private int idFile;
    private boolean error;
    private String file;
    private String message;

}
