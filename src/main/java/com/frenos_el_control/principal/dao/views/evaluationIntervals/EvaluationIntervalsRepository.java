package com.frenos_el_control.principal.dao.views.evaluationIntervals;

import com.frenos_el_control.principal.entity.view.evaluationIntervals.EvaluationIntervalsMonth;

import java.util.List;
import java.util.Optional;

public interface EvaluationIntervalsRepository {
    Optional<List<EvaluationIntervalsMonth>> intervalMonth();
}
