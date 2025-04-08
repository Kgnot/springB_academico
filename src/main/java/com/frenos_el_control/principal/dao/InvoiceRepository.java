package com.frenos_el_control.principal.dao;

import com.frenos_el_control.principal.entity.Invoice;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.sql.Date;
import java.util.List;

public interface InvoiceRepository extends JpaRepository<Invoice, Integer> {

    Page<Invoice> findByCustomer_CustomerId(Integer customerId, Pageable pageable);

    Page<Invoice> findByVehicle_VehicleId(Integer vehicleId, Pageable pageable);

    List<Invoice> findByDateOrderedBetween(Date startDate, Date endDate);

    List<Invoice> findByDateOrdered(Date dateOrdered);
}
