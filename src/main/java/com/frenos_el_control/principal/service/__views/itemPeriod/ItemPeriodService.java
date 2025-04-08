package com.frenos_el_control.principal.service.__views.itemPeriod;

import com.frenos_el_control.principal.entity.view.quantityItem.QuantityGenericItem;

import java.util.Optional;

public interface ItemPeriodService {


    Optional<QuantityGenericItem> findQuantityPerMonth();

    Optional<QuantityGenericItem> findQuantityPerQuarter();

    Optional<QuantityGenericItem> findQuantityPerYear();

}
