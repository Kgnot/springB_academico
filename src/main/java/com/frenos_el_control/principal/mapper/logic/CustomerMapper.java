package com.frenos_el_control.principal.mapper.logic;

import com.frenos_el_control.principal.dto.CustomerDTO;
import com.frenos_el_control.principal.entity.Customer;
import org.springframework.stereotype.Component;

@Component
public class CustomerMapper implements GenericMapper<Customer, CustomerDTO> {

    @Override
    public CustomerDTO toDTO(Customer customer) {
        return CustomerDTO.builder()
                .name(customer.getName())
                .identify(customer.getIdentify())
                .direction(customer.getAddress())
                .phone(customer.getPhone())
                .build();
    }

    @Override
    public Customer toEntity(CustomerDTO dto) {
        return Customer.builder()
                .name(dto.getName())
                .identify(dto.getIdentify())
                .address(dto.getDirection())
                .phone(dto.getPhone())
                .build();
    }
}
