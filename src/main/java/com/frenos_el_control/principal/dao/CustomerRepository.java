package com.frenos_el_control.principal.dao;

import com.frenos_el_control.principal.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

    List<Customer> findByNameStartingWith(String name);
    List<Customer> findByNameContaining(String partName);
    Customer findByName(String description);

}
