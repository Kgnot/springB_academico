package com.frenos_el_control.principal.dao.views.bestSellingProduct;

import com.frenos_el_control.principal.entity.view.bestSellingProduct.BestSellingProductSummary;

import java.util.Optional;

public interface SellingProductRepository {

    Optional<BestSellingProductSummary> findBestProduct();
}
