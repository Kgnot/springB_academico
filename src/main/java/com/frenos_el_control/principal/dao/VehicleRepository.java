package com.frenos_el_control.principal.dao;

import com.frenos_el_control.principal.entity.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VehicleRepository extends JpaRepository<Vehicle, Integer> {

    List<Vehicle> findByCustomer_customerId(int id);

}
