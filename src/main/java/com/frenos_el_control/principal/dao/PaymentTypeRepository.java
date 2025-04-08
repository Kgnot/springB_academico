package com.frenos_el_control.principal.dao;

import com.frenos_el_control.principal.entity.PaymentType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentTypeRepository extends JpaRepository<PaymentType, String> {

}
