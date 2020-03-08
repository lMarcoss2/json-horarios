package edu.calc.json.horarios.mcarga.hrs.read.files.model;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

/**
 * @author Marcos Santiago Leonardo
 * Universidad de la Sierra Sur (UNSIS)
 * Description:
 * Date: 5/13/19
 */
@NoArgsConstructor
@Getter
@Setter
public class RowFile {
    private List<CellFile> cells;
}
