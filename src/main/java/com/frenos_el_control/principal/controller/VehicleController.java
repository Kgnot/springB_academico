package com.frenos_el_control.principal.controller;


import com.frenos_el_control.principal.entity.Vehicle;
import com.frenos_el_control.principal.service.vehicle.VehicleService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/vehicles")
@RequiredArgsConstructor
@RestController
public class VehicleController {

    private final VehicleService service;

    @GetMapping("/customer/{id}")
    public List<Vehicle> findByCustomerId(@PathVariable int id) {
        return service.findByCustomerId(id);
    }
    @GetMapping("/{id}")
    public Vehicle findById(@PathVariable int id) {
        return service.findById(id);
    }
    @PostMapping()
    public Vehicle save(@RequestBody Vehicle vehicle) {
        return service.save(vehicle);
    }
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable int id) {
        service.deleteById(id);
    }

}
