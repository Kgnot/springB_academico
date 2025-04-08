package com.frenos_el_control.principal.service.paymentType;

import com.frenos_el_control.principal.dao.PaymentTypeRepository;
import com.frenos_el_control.principal.entity.PaymentType;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PaymentTypeServiceImpl implements PaymentTypeService {

    private final PaymentTypeRepository repository;
    @Override
    public List<PaymentType> findAll() {
        return repository.findAll();
    }
}
