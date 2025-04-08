package com.frenos_el_control.principal.service.__views.topPerformingProduct;

import com.frenos_el_control.principal.entity.view.topPerformingProducts.TopPerformingProducts;

import java.util.List;
import java.util.Optional;

public interface TopPerformingProductService {

    public Optional<List<TopPerformingProducts>> getTop();
}
