package com.frenos_el_control.principal.service.__views.bestSellingProduct;

import com.frenos_el_control.principal.entity.view.bestSellingProduct.BestSellingProductSummary;

import java.util.Optional;

public interface SellingProductService {

    Optional<BestSellingProductSummary> findBestProduct();

}
