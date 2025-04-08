package com.frenos_el_control.principal.controller.db2;


import com.frenos_el_control.principal.entity.DB2.BrandCar;
import com.frenos_el_control.principal.exception.BrandCarException;
import com.frenos_el_control.principal.service.__db2.brandCar.BrandCarService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/brand_car")
@RequiredArgsConstructor
public class BrandCarController {

    private final BrandCarService service;

    @GetMapping()
    public List<BrandCar> findAllBrand() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable String id) throws BrandCarException {
        BrandCar brand_c = service.findById(id);
        return ResponseEntity.ok(brand_c);
    }

    @PostMapping()
    public BrandCar save(@RequestBody BrandCar brandCar)
    {
        return service.save(brandCar);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteById(@PathVariable String id) {
        return service.deleteById(id)
                ? ResponseEntity.ok("Eliminado")
                : ResponseEntity.status(HttpStatus.CONFLICT).body("No se pudo eliminar");
    }
}
