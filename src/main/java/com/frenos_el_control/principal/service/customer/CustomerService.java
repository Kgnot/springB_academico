package com.frenos_el_control.principal.service.customer;

import com.frenos_el_control.principal.dto.CustomerDTO;
import com.frenos_el_control.principal.entity.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CustomerService {
    Page<Customer> findAll(Pageable page);
    Customer findByName(String name);
    CustomerDTO save(CustomerDTO customer);
    List<Customer> findByNameStartingWith(String name);
    List<Customer> findByNameContaining(String partName);

}
