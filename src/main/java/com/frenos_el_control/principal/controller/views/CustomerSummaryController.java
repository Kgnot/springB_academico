package com.frenos_el_control.principal.controller.views;

import com.frenos_el_control.principal.service.__views.customerSummary.CustomerSummaryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/stats/customer")
@RequiredArgsConstructor
public class CustomerSummaryController {

    private final CustomerSummaryService service;

    @GetMapping("/summary")
    public ResponseEntity<?> getStatCustomer()
    {
        var stat = service.getCustomer();
        return stat.isPresent()?
                ResponseEntity.ok(stat.get()):

                ResponseEntity.notFound().build();
    }

    @GetMapping("/top")
    public ResponseEntity<?> getTopCustomers()
    {
        var stat = service.getTopCustomers();
        return stat.isPresent()?
                ResponseEntity.ok(stat.get()):
                ResponseEntity.notFound().build();
    }

}
