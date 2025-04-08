package com.frenos_el_control.principal.controller.db2;


import com.frenos_el_control.principal.entity.DB2.Inventory;
import com.frenos_el_control.principal.exception.InventoryException;
import com.frenos_el_control.principal.service.__db2.inventory.InventoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/inventory")
@RequiredArgsConstructor
public class InventoryController {

    private final InventoryService service;

    @GetMapping
    public Page<Inventory> findAll(@PageableDefault(size = 30) Pageable pageable)
    {
        return service.findAll(pageable);
    }

    @GetMapping("/{id}")
    public Inventory findById(@PathVariable int id) throws InventoryException
    {
        return service.findById(id);
    }

    @GetMapping("brand/{brand}")
    public Page<Inventory> findByBrand(@PathVariable String brand,@PageableDefault(size = 30) Pageable pageable)
    {
        return service.findInventoriesByBrandCarId(brand,pageable);
    }

    @GetMapping("car_type/{type}")
    public Page<Inventory> findByCarType(@PathVariable String type,@PageableDefault(size = 30) Pageable pageable)
    {
        return service.findInventoriesByCarType(type,pageable);
    }

    //TODO: Posiblemente hacer DTO
    @PostMapping()
    public Inventory save(@RequestBody Inventory inv)
    {
        return service.save(inv);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteById(@PathVariable int id) {
        return service.deleteById(id)
                ? ResponseEntity.ok("Eliminado")
                : ResponseEntity.status(HttpStatus.CONFLICT).body("No se pudo eliminar");
    }

}
