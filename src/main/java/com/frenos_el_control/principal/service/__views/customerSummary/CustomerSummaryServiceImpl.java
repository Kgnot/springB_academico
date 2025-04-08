package com.frenos_el_control.principal.service.__views.customerSummary;

import com.frenos_el_control.principal.dao.views.customerSummary.CustomerSummaryViewRepository;
import com.frenos_el_control.principal.entity.view.customerSummary.CustomerSummaryView;
import com.frenos_el_control.principal.entity.view.topCustomer.TopCustomer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustomerSummaryServiceImpl implements CustomerSummaryService {

    private final CustomerSummaryViewRepository repository;

    @Override
    public Optional<List<CustomerSummaryView>> getCustomer() {
        return repository.getCustomer();
    }

    @Override
    public Optional<List<TopCustomer>> getTopCustomers() {
        return repository.getTopCustomers();
    }
}
