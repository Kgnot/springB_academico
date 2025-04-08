package com.frenos_el_control.principal.service.vehicle;

import com.frenos_el_control.principal.entity.Vehicle;

import java.util.List;

public interface VehicleService {
    List<Vehicle> findByCustomerId(int id);
    Vehicle findById(int id);
    Vehicle save(Vehicle vehicleDTO);
    void deleteById(int id);
}
