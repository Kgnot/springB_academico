package com.frenos_el_control.principal.service.__views.salesPeriod;


import com.frenos_el_control.principal.entity.view.currentSales.CurrentGenericSales;

import java.util.Optional;

public interface SalesPeriodService {

    Optional<CurrentGenericSales> findByMonth();
    Optional<CurrentGenericSales> findByQuarter();
    Optional<CurrentGenericSales> findByYear();



}
