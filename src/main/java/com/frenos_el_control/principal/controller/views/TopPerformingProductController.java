package com.frenos_el_control.principal.controller.views;


import com.frenos_el_control.principal.entity.view.topPerformingProducts.TopPerformingProducts;
import com.frenos_el_control.principal.service.__views.topPerformingProduct.TopPerformingProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("stats/products/top-performing")
@RequiredArgsConstructor
public class TopPerformingProductController {

    private final TopPerformingProductService service;


    @GetMapping
    public Optional<List<TopPerformingProducts>> getTop() {
        return service.getTop();
    }

}
