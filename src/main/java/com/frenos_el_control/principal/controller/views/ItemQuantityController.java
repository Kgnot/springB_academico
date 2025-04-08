package com.frenos_el_control.principal.controller.views;


import com.frenos_el_control.principal.service.__views.itemPeriod.ItemPeriodService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/stats/item")
@RestController
@RequiredArgsConstructor
public class ItemQuantityController {

    private final ItemPeriodService service;

    @GetMapping("/month")
    public ResponseEntity<?> getMonthSales() {
        var ret = service.findQuantityPerMonth();
        return ret.isPresent() ?
                ResponseEntity.ok(ret.get()) :
                ResponseEntity.status(HttpStatus.NOT_FOUND).body("No encontrado");
    }

    @GetMapping("/quarter")
    public ResponseEntity<?> getQuarterSales() {
        var ret = service.findQuantityPerQuarter();
        return ret.isPresent() ?
                ResponseEntity.ok(ret.get()) :
                ResponseEntity.status(HttpStatus.NOT_FOUND).body("No encontrado");
    }

    @GetMapping("/year")
    public ResponseEntity<?> getYearSales() {
        var ret = service.findQuantityPerYear();
        return ret.isPresent() ?
                ResponseEntity.ok(ret.get()) :
                ResponseEntity.status(HttpStatus.NOT_FOUND).body("No encontrado");
    }

}
