package com.frenos_el_control.principal.service.__views.salesPeriod;

import com.frenos_el_control.principal.dao.views.currentGenericSales.CurrentGenericSalesRepository;
import com.frenos_el_control.principal.entity.view.currentSales.CurrentGenericSales;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SalesPeriodServiceImpl implements SalesPeriodService {
    private final CurrentGenericSalesRepository salesRepository;
    @Override
    public Optional<CurrentGenericSales> findByMonth() {
        return salesRepository.findMonthSales();
    }
    @Override
    public Optional<CurrentGenericSales> findByQuarter() {
        return salesRepository.findQuarterSales();
    }

    @Override
    public Optional<CurrentGenericSales> findByYear() {
        return salesRepository.findCurrentYearSales();
    }
}
