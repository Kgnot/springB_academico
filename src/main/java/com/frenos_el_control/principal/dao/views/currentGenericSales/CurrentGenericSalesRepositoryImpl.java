package com.frenos_el_control.principal.dao.views.currentGenericSales;

import com.frenos_el_control.principal.entity.view.currentSales.CurrentGenericSales;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class CurrentGenericSalesRepositoryImpl implements CurrentGenericSalesRepository {
    private final EntityManager manager;

    @Override
    public Optional<CurrentGenericSales> findMonthSales() {
        return mapToDto(manager.createNativeQuery("SELECT id, total, prcnt FROM current_month_sales")
                .getSingleResult());
    }

    @Override
    public Optional<CurrentGenericSales> findQuarterSales() {
        return mapToDto(manager.createNativeQuery("SELECT id, total, prcnt FROM current_quarter_sales")
                .getSingleResult());
    }

    @Override
    public Optional<CurrentGenericSales> findCurrentYearSales() {
        return mapToDto(manager.createNativeQuery("SELECT id, total, prcnt FROM current_year_sales")
                .getSingleResult());
    }

    private Optional<CurrentGenericSales> mapToDto(Object result) {
        if (result == null) return Optional.empty();
        Object[] row = (Object[]) result;
        return Optional.of(new CurrentGenericSales(
                ((Number) row[0]).intValue(),
                (BigDecimal) row[1],
                (BigDecimal) row[2]
        ));
    }
}

