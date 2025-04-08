package com.frenos_el_control.principal.dao.views.quantityGenericItem;

import com.frenos_el_control.principal.entity.view.quantityItem.QuantityGenericItem;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class QuantityGenericItemRepositoryImpl implements QuantityGenericItemRepository {

    private final EntityManager manager;

    @Override
    public Optional<QuantityGenericItem> findQuantityPerMonth() {
        return mapToDto(manager.createNativeQuery("select * from quantity_item_type_month"));
    }

    @Override
    public Optional<QuantityGenericItem> findQuantityPerQuarter() {
        return mapToDto(manager.createNativeQuery("select * from quantity_item_type_quarter"));
    }

    @Override
    public Optional<QuantityGenericItem> findQuantityPerYear() {
        return mapToDto(manager.createNativeQuery("select * from quantity_item_type_year"));
    }


    private Optional<QuantityGenericItem> mapToDto(Object obj)
    {
        if(obj == null) return Optional.empty();
        Object[] row = (Object[]) obj;

        return Optional.of(new QuantityGenericItem(
                (String) row[1],
                (Integer) row[2],
                (Integer) row[3],
                (BigDecimal) row[4]
        ));

    }

}
