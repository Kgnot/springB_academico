package com.frenos_el_control.principal.controller;


import com.frenos_el_control.principal.entity.PaymentType;
import com.frenos_el_control.principal.service.paymentType.PaymentTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/payment_type")
@RequiredArgsConstructor
public class PaymentTypeController {

    private final PaymentTypeService service;


    @GetMapping()
    public List<PaymentType> getAllPaymentTypes() {
        return service.findAll();
    }


}
