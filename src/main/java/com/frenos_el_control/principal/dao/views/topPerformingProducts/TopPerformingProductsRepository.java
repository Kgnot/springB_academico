package com.frenos_el_control.principal.dao.views.topPerformingProducts;

import com.frenos_el_control.principal.entity.view.topPerformingProducts.TopPerformingProducts;

import java.util.List;
import java.util.Optional;

public interface TopPerformingProductsRepository {

        Optional<List<TopPerformingProducts>> getTop();

}
