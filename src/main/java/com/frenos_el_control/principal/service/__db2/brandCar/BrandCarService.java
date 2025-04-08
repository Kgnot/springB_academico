package com.frenos_el_control.principal.service.__db2.brandCar;

import com.frenos_el_control.principal.entity.DB2.BrandCar;
import com.frenos_el_control.principal.exception.BrandCarException;

import java.util.List;

public interface BrandCarService {

    List<BrandCar> findAll();
    BrandCar findById(String id) throws BrandCarException;
    BrandCar save(BrandCar brand);
    boolean deleteById(String brand);

}
