package com.frenos_el_control.principal.service.__views.bestSellingProduct;

import com.frenos_el_control.principal.dao.views.bestSellingProduct.SellingProductRepository;
import com.frenos_el_control.principal.entity.view.bestSellingProduct.BestSellingProductSummary;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BestSellingProductServiceImpl  implements SellingProductService{

    private final SellingProductRepository repository;

    @Override
    public Optional<BestSellingProductSummary> findBestProduct() {
        return repository.findBestProduct();
    }
}
