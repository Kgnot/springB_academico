package com.frenos_el_control.principal.service.invoice;

import com.frenos_el_control.principal.entity.Invoice;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.sql.Date;
import java.util.List;

public interface InvoiceService {
    Page<Invoice> findAll(Pageable pageable);

    Invoice findById(int id);

    Invoice save(Invoice invoice);

    void deleteById(int id);

    Page<Invoice> findByCustomerId(Integer id, Pageable pageableCustomerId);

    List<Invoice> findByDateOrdered(Date dateOrdered);

    Page<Invoice> findByVehicle(Integer id,Pageable pageableVehicleId);
}
