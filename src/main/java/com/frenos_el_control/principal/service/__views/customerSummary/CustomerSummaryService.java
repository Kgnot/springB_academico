package com.frenos_el_control.principal.service.__views.customerSummary;

import com.frenos_el_control.principal.entity.view.customerSummary.CustomerSummaryView;
import com.frenos_el_control.principal.entity.view.topCustomer.TopCustomer;

import java.util.List;
import java.util.Optional;

public interface CustomerSummaryService {

    Optional<List<CustomerSummaryView>> getCustomer();
    Optional<List<TopCustomer>> getTopCustomers();

}
