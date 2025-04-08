package com.frenos_el_control.principal.controller.views;


import com.frenos_el_control.principal.service.__views.bestSellingProduct.SellingProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/stats/product")
@RequiredArgsConstructor
public class SellingProductController {
    private final SellingProductService service;

    @GetMapping("/best")
    public ResponseEntity<?> getStatCustomer()
    {
        var stat = service.findBestProduct();
        return stat.isPresent()?
                ResponseEntity.ok(stat.get()):
                ResponseEntity.notFound().build();
    }

}
