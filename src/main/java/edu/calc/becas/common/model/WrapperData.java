package edu.calc.becas.common.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

/**
 * @author Marcos Santiago Leonardo
 * Universidad de la Sierra Sur (UNSIS)
 * Description: Wrapper for data send to front
 * Date: 3/24/19
 */
@Setter
@Getter
@AllArgsConstructor
public class WrapperData<T> implements Serializable {
    private List<T> data;
    private int page;
    private int pageSize;
    private int lengthData;
}
