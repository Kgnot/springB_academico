package com.frenos_el_control.principal.controller.db2;


import com.frenos_el_control.principal.entity.DB2.SaleHistoryPrice;
import com.frenos_el_control.principal.exception.HistoryPriceException;
import com.frenos_el_control.principal.service.__db2.historyService.HistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.time.LocalDate;

@RestController
@RequestMapping("/sale_history")
public class SaleHistoryController {

    private final HistoryService<SaleHistoryPrice> service;

    @Autowired
    public SaleHistoryController(@Qualifier("saleHistoryServiceImpl") HistoryService<SaleHistoryPrice> service) {
        this.service = service;
    }

    @GetMapping()
    public Page<SaleHistoryPrice> findAll(Pageable pageable)
    {
        return service.findAll(pageable);
    }
    @GetMapping("/{id}")
    public SaleHistoryPrice findById(@PathVariable int id) throws HistoryPriceException
    {
        return service.findById(id);
    }

    @GetMapping("inventory/{id}")
    public Page<SaleHistoryPrice> findHistoryPricesByInventory(@PathVariable int id, @PageableDefault(size = 30)  Pageable pageable)
    {
        return service.findHistoryPricesByInventory(id,pageable);
    }

    @GetMapping("by_date")
    public Page<SaleHistoryPrice> findByDates(
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate start,
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate finish,
            @PageableDefault(size = 30)  Pageable pageable
    ) {
        if (start == null) {
            start = LocalDate.now().minusMonths(1); // Último mes por defecto
        }
        if (finish == null) {
            finish = LocalDate.now();
        }
        if (start.isAfter(finish)) {
            throw new IllegalArgumentException("La fecha de inicio no puede ser mayor que la fecha de fin.");
        }
        Date sqlStart = Date.valueOf(start);
        Date sqlFinish = Date.valueOf(finish);
        return service.findHistoryPricesByDatePriceBetween(sqlStart, sqlFinish,pageable);
    }
    @PostMapping()
    public SaleHistoryPrice save(@RequestBody SaleHistoryPrice price)
    {
        return service.save(price);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteById(@PathVariable int id) {
        return service.deleteById(id)
                ? ResponseEntity.ok("Eliminado")
                : ResponseEntity.status(HttpStatus.CONFLICT).body("No se pudo eliminar");
    }


}
