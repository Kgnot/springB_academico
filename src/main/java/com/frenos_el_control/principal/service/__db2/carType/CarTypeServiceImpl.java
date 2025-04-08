package com.frenos_el_control.principal.service.__db2.carType;

import com.frenos_el_control.principal.dao.db2.CarTypeRepository;
import com.frenos_el_control.principal.entity.DB2.CarType;
import com.frenos_el_control.principal.exception.CarTypeException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CarTypeServiceImpl implements CarTypeService {

    private final CarTypeRepository repository;

    @Override
    public List<CarType> findAll() {
        return repository.findAll();
    }

    @Override
    public CarType findById(int id) throws CarTypeException {
        return repository.findById(id).orElseThrow(CarTypeException::new);
    }

    @Override
    public CarType save(CarType carType) {
        return repository.save(carType);
    }

    @Override
    public boolean deleteById(int carType) {
        repository.deleteById(carType);
        return !repository.existsById(carType);
    }
}
