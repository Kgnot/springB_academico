package com.frenos_el_control.principal.entity.view.evaluationIntervals;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EvaluationIntervalsMonth {
    private  String period;
    private Date startDate;
    private Date endDate;
    private BigDecimal amount;

}
