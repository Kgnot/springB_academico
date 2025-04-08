package com.frenos_el_control.principal.service.__views.topPerformingProduct;

import com.frenos_el_control.principal.dao.views.topPerformingProducts.TopPerformingProductsRepository;
import com.frenos_el_control.principal.entity.view.topPerformingProducts.TopPerformingProducts;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TopPerformingProductImpl implements TopPerformingProductService {


    private final TopPerformingProductsRepository repository;

    @Override
    public Optional<List<TopPerformingProducts>> getTop() {
        return repository.getTop();
    }
}
