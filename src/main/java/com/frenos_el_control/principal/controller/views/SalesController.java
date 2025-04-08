package com.frenos_el_control.principal.controller.views;


import com.frenos_el_control.principal.service.__views.salesPeriod.SalesPeriodService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/stats/sales")
@RequiredArgsConstructor
public class SalesController {

    private final SalesPeriodService service;


    @GetMapping("/month")
    public ResponseEntity<?> getMonthSales() {
        var ret = service.findByMonth();
        return ret.isPresent() ?
                ResponseEntity.ok(ret.get()) :
                ResponseEntity.status(HttpStatus.NOT_FOUND).body("No encontrado");
    }

    @GetMapping("/quarter")
    public ResponseEntity<?> getQuarterSales() {
        var ret = service.findByQuarter();
        return ret.isPresent() ?
                ResponseEntity.ok(ret.get()) :
                ResponseEntity.status(HttpStatus.NOT_FOUND).body("No encontrado");
    }

    @GetMapping("/year")
    public ResponseEntity<?> getYearSales() {
        var ret = service.findByYear();
        return ret.isPresent() ?
                ResponseEntity.ok(ret.get()) :
                ResponseEntity.status(HttpStatus.NOT_FOUND).body("No encontrado");
    }

}
