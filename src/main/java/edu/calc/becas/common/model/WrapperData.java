package edu.calc.becas.common.model;

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
public class WrapperData<T> implements Serializable {
    private List<T> data;
    private int page;
    private int pageSize;
    private int lengthData;


    public WrapperData(List<T> data, int page, int pageSize, int lengthData) {
        this.data = data;
        this.page = page;
        this.pageSize = pageSize;
        this.lengthData = lengthData;

    }
}
