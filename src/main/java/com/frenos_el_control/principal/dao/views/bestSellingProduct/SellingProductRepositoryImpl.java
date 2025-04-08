package com.frenos_el_control.principal.dao.views.bestSellingProduct;

import com.frenos_el_control.principal.entity.view.bestSellingProduct.BestSellingProductSummary;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class SellingProductRepositoryImpl implements SellingProductRepository {

    private final EntityManager manager;


    @Override
    public Optional<BestSellingProductSummary> findBestProduct() {
        return mapToDto(manager.createNativeQuery("select * from best_selling_product_summary").getSingleResult());
    }


    private Optional<BestSellingProductSummary> mapToDto(Object obj) {
        if (obj == null) return Optional.empty();

        Object[] row = (Object[]) obj;

        return Optional.of(new BestSellingProductSummary(
                (String) row[0],
                (BigDecimal) row[1],
                (Integer) row[2],
                (String) row[3],
                (Integer) row[4],
                (Double) row[5]
        ));

    }

}
