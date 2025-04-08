package com.frenos_el_control.principal.service.__db2.carType;

import com.frenos_el_control.principal.entity.DB2.CarType;
import com.frenos_el_control.principal.exception.CarTypeException;

import java.util.List;

public interface CarTypeService {

    List<CarType> findAll();
    CarType findById(int id) throws CarTypeException;
    CarType save(CarType carType);
    boolean deleteById(int id);

}
