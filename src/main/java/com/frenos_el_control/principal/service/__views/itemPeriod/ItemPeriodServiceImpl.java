package com.frenos_el_control.principal.service.__views.itemPeriod;

import com.frenos_el_control.principal.dao.views.quantityGenericItem.QuantityGenericItemRepository;
import com.frenos_el_control.principal.entity.view.quantityItem.QuantityGenericItem;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ItemPeriodServiceImpl implements ItemPeriodService {

    private final QuantityGenericItemRepository repository;

    @Override
    public Optional<QuantityGenericItem> findQuantityPerMonth() {
        return repository.findQuantityPerMonth();
    }

    @Override
    public Optional<QuantityGenericItem> findQuantityPerQuarter() {
        return repository.findQuantityPerQuarter();
    }

    @Override
    public Optional<QuantityGenericItem> findQuantityPerYear() {
        return repository.findQuantityPerYear();
    }
}
