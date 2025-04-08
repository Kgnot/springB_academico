package com.frenos_el_control.principal.controller;

import com.frenos_el_control.principal.dto.CustomerDTO;
import com.frenos_el_control.principal.entity.Customer;
import com.frenos_el_control.principal.service.customer.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService service;

    @GetMapping()
    public Page<Customer> getAll(@PageableDefault(size = 30) Pageable pageable) {
        return service.findAll(pageable);
    }

    @GetMapping("/{name}")
    public Customer getByName(@PathVariable String name) {
        return service.findByName(name);
    }

    @GetMapping("/name/{letter}")
    public List<Customer> getByNameStartingWith(@PathVariable String letter) {
        return service.findByNameStartingWith(letter);
    }
    @GetMapping("name/containing/{part}")
    public List<Customer> getByNameContaining(@PathVariable String part)
    {
        return service.findByNameContaining(part);
    }

    // Añadir un cliente
    @PostMapping()
    public CustomerDTO addCustomer(@RequestBody CustomerDTO customer){

        return service.save(customer);
    }

    // Modificar un cliente
    @PutMapping()
    public CustomerDTO editCustomer(@RequestBody CustomerDTO customer){
        return service.save(customer);
    }
}
