package edu.calc.json.horarios.common.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

/**
 * @author Marcos Santiago Leonardo
 * Meltsan Solutions
 * Description: Datos de paginación para consultas
 * Date: 2019-07-10
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Pageable implements Serializable {
    private int page;
    private int pageSize;
}
