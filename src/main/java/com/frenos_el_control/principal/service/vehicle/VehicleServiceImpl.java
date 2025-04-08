package com.frenos_el_control.principal.service.vehicle;

import com.frenos_el_control.principal.dao.VehicleRepository;
import com.frenos_el_control.principal.entity.Vehicle;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class VehicleServiceImpl implements VehicleService{

    private final VehicleRepository repository;

    @Override
    public List<Vehicle> findByCustomerId(int id) {
        return repository.findByCustomer_customerId(id);
    }

    @Override
    public Vehicle findById(int id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Vehicle save(Vehicle vehicle) {
        return repository.save(vehicle);
    }

    @Override
    public void deleteById(int id) {
        repository.deleteById(id);  // Si no existe, lanza una excepción
    }
}
