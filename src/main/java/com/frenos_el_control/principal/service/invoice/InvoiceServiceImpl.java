package com.frenos_el_control.principal.service.invoice;

import com.frenos_el_control.principal.dao.InvoiceRepository;
import com.frenos_el_control.principal.entity.Invoice;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class InvoiceServiceImpl implements InvoiceService {
    private final InvoiceRepository repository;


    @Override
    public Page<Invoice> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public Invoice findById(int id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Invoice save(Invoice invoice) {

        return repository.save(invoice);
    }

    @Override
    public void deleteById(int id) {
        repository.deleteById(id);
    }

    @Override
    public Page<Invoice> findByCustomerId(Integer id, Pageable pagable) {
        return repository.findByCustomer_CustomerId(id,pagable);
    }

    @Override
    public List<Invoice> findByDateOrdered(Date dateOrdered) {
        return repository.findByDateOrdered(dateOrdered);
    }


    @Override
    public Page<Invoice> findByVehicle(Integer id, Pageable pageableVehicleId) {
        return repository.findByVehicle_VehicleId(id, pageableVehicleId);
    }
}
