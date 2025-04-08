package com.frenos_el_control.principal.service.__views.evaluationIntervals;

import com.frenos_el_control.principal.entity.view.evaluationIntervals.EvaluationIntervalsMonth;

import java.util.List;
import java.util.Optional;

public interface EvaluationIntervalsService {

    Optional<List<EvaluationIntervalsMonth>> intervalMonth();
}
