package com.frenos_el_control.principal.dao.views.currentGenericSales;

import com.frenos_el_control.principal.entity.view.currentSales.CurrentGenericSales;
import java.util.Optional;


public interface CurrentGenericSalesRepository{

    Optional<CurrentGenericSales> findMonthSales();

    Optional<CurrentGenericSales> findQuarterSales();

    Optional<CurrentGenericSales> findCurrentYearSales();
}
