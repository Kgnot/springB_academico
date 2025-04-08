package com.frenos_el_control.principal.controller.views;


import com.frenos_el_control.principal.service.__views.evaluationIntervals.EvaluationIntervalsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/stats/evaluation_intervals")
@RequiredArgsConstructor
public class EvaluationIntervalsController {

    private final EvaluationIntervalsService service;

    @GetMapping("/month")
    public ResponseEntity<?> getMonthEvaluation() {
        var ret = service.intervalMonth();
        return ret.isPresent() ?
                ResponseEntity.ok(ret.get()) :
                ResponseEntity.status(HttpStatus.NOT_FOUND).body("No encontrado");
    }




}
