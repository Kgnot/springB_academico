package com.frenos_el_control.principal.dao.views.topPerformingProducts;

import com.frenos_el_control.principal.entity.view.topPerformingProducts.TopPerformingProducts;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class TopPerformingProductsRepositoryImpl implements TopPerformingProductsRepository {

    private final EntityManager manager;

    @Override
    public Optional<List<TopPerformingProducts>> getTop() {

        List<Object[]> list = manager.createNativeQuery("select * from top_performing_products").getResultList();

        return toMap(list);
    }


    private Optional<List<TopPerformingProducts>> toMap(List<Object[]> list) {
        if (list.isEmpty()) return Optional.empty();

        List<TopPerformingProducts> ret = list.stream().map(
                (Object[] obj) -> {

                    return new TopPerformingProducts(
                            (String) obj[0],
                            (Integer) obj[1],
                            (BigDecimal) obj[2],
                            (Integer) obj[3],
                            (BigDecimal) obj[4]
                    );
                }
        ).toList();

        return Optional.of(ret);

    }


}
