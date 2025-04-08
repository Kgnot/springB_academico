package com.frenos_el_control.principal.service.__views.evaluationIntervals;

import com.frenos_el_control.principal.dao.views.evaluationIntervals.EvaluationIntervalsRepository;
import com.frenos_el_control.principal.entity.view.evaluationIntervals.EvaluationIntervalsMonth;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EvaluationIntervalsServiceImpl implements EvaluationIntervalsService {

    private final EvaluationIntervalsRepository repository;

    @Override
    public Optional<List<EvaluationIntervalsMonth>> intervalMonth() {
        return repository.intervalMonth();
    }
}
