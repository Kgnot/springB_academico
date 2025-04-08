package com.frenos_el_control.principal.dao.views.customerSummary;

import com.frenos_el_control.principal.entity.view.customerSummary.CustomerSummaryView;
import com.frenos_el_control.principal.entity.view.topCustomer.TopCustomer;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@Repository
@RequiredArgsConstructor
public class CustomerSummaryViewRepositoryImpl implements CustomerSummaryViewRepository {

    private final EntityManager manager;

    @Override
    public Optional<List<CustomerSummaryView>> getCustomer() {
        return fetchAndMap("select * from customer_summary_view", CustomerSummaryViewRepositoryImpl::mapToCustomerSummaryView);
    }

    @Override
    public Optional<List<TopCustomer>> getTopCustomers() {
        return fetchAndMap("select * from top_customers_summary", CustomerSummaryViewRepositoryImpl::mapToTopCustomer);
    }

    private <T> Optional<List<T>> fetchAndMap(String query, Function<Object[], T> mapper) {
        List<Object[]> result = manager.createNativeQuery(query).getResultList();
        if (result.isEmpty()) {
            return Optional.empty();
        }
        return Optional.of(result.stream()
                .map(mapper)
                .toList());
    }

    private static CustomerSummaryView mapToCustomerSummaryView(Object[] obj) {
        return new CustomerSummaryView(
                (String) obj[0],
                (Integer) obj[1],
                (BigDecimal) obj[2],
                (String) obj[3]
        );
    }

    private static TopCustomer mapToTopCustomer(Object[] obj) {
        return new TopCustomer(
                (String) obj[0],
                (BigDecimal) obj[1],
                (Integer) obj[2],
                (BigDecimal) obj[3],
                (Date) obj[4],
                (String) obj[5],
                (Integer) obj[6]
        );
    }
}