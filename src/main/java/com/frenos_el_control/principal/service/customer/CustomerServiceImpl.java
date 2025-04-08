package com.frenos_el_control.principal.service.customer;

import com.frenos_el_control.principal.dao.CustomerRepository;
import com.frenos_el_control.principal.dto.CustomerDTO;
import com.frenos_el_control.principal.entity.Customer;
import com.frenos_el_control.principal.mapper.service.MapperService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository repository;
    private final MapperService mapperService;

    @Override
    public Page<Customer> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public Customer findByName(String name) {
        return repository.findByName(name);
    }

    @Override
    public CustomerDTO save(CustomerDTO customerDTO) {
        Customer customer = mapperService.toEntity(customerDTO);
        customer = repository.save(customer);
        return mapperService.toDTO(customer);

    }

    @Override
    public List<Customer> findByNameStartingWith(String name) {
        return repository.findByNameStartingWith(name);
    }

    @Override
    public List<Customer> findByNameContaining(String partName) {
        return repository.findByNameContaining(partName);
    }
}
