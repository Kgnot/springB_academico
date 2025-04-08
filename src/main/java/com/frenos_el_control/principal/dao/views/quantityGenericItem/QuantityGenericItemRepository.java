package com.frenos_el_control.principal.dao.views.quantityGenericItem;

import com.frenos_el_control.principal.entity.view.quantityItem.QuantityGenericItem;

import java.util.Optional;

public interface QuantityGenericItemRepository {

    Optional<QuantityGenericItem> findQuantityPerMonth();

    Optional<QuantityGenericItem> findQuantityPerQuarter();

    Optional<QuantityGenericItem> findQuantityPerYear();

}
