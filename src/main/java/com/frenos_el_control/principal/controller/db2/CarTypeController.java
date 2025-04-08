package com.frenos_el_control.principal.controller.db2;

import com.frenos_el_control.principal.entity.DB2.CarType;
import com.frenos_el_control.principal.exception.CarTypeException;
import com.frenos_el_control.principal.service.__db2.carType.CarTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/car_type")
@RequiredArgsConstructor
public class CarTypeController {

    private final CarTypeService service;

    @GetMapping()
    public List<CarType> findAll()
    {
        return service.findAll();
    }
    @GetMapping("/{id}")
    public CarType findById(@PathVariable int id) throws CarTypeException {
        return service.findById(id);
    }

    @PostMapping()
    public CarType save(@RequestBody CarType cartype) // Esto posiblemente sea un dto
    {
        return service.save(cartype);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteById(@PathVariable int id){
        return service.deleteById(id)
                ? ResponseEntity.ok("Eliminado")
                : ResponseEntity.status(HttpStatus.CONFLICT).body("No se pudo eliminar");
    }

}
