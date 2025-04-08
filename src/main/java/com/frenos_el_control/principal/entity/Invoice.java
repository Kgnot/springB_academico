package com.frenos_el_control.principal.entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;

@Entity
@Table(name = "INVOICE")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Invoice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "invoice_id")
    private int invoiceId;
    @Column(name = "date_ordered", nullable = false)
    private Date dateOrdered;
    @Column(name = "total", nullable = false)
    private BigDecimal total;
    //Relaciones:
    @ManyToOne
    @JoinColumn(name = "vehicle_id")
    private Vehicle vehicle;
    @ManyToOne
    @JoinColumn(name = "payment_type")
    private PaymentType paymentType;
    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;
    @ManyToOne
    @JoinColumn(name = "status_id")
    @JsonBackReference(value = "invoice-status")
    private StatusInvoice status;
    @OneToMany(mappedBy = "invoice", cascade = CascadeType.ALL , orphanRemoval = true)
    @JsonManagedReference(value = "invoice-items")
    private List<InvoiceItem> invoiceItems;
}
