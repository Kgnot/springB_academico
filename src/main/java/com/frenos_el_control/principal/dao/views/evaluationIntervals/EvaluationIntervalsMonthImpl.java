package com.frenos_el_control.principal.dao.views.evaluationIntervals;


import com.frenos_el_control.principal.dao.views.customerSummary.CustomerSummaryViewRepositoryImpl;
import com.frenos_el_control.principal.entity.view.customerSummary.CustomerSummaryView;
import com.frenos_el_control.principal.entity.view.evaluationIntervals.EvaluationIntervalsMonth;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
public class EvaluationIntervalsMonthImpl implements EvaluationIntervalsRepository{

    private final EntityManager manager;

    @Override
    @SuppressWarnings("unchecked")
    public Optional<List<EvaluationIntervalsMonth>> intervalMonth() {
        return mapToDto(manager.createNativeQuery("select *  from evaluation_intervals_month").getResultList());
    }


    private Optional<List<EvaluationIntervalsMonth>> mapToDto(List<Object[]> objects) {
        if (objects.isEmpty()) return Optional.empty();

        List<CustomerSummaryView> list;

        return Optional.of(objects.stream()
                .map(EvaluationIntervalsMonthImpl::mapping)
                .toList());
    }

    private static EvaluationIntervalsMonth mapping(Object[] obj) {

        return new EvaluationIntervalsMonth(
                (String) obj[0],
                (Date) obj[1],
                (Date) obj[2],
                (BigDecimal) obj[3]);
    }



}
