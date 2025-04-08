package com.frenos_el_control.principal.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name="PAYMENTTYPE")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaymentType {
    @Id
    @Column(name="payment_type")
    private String paymentType;
    @OneToMany(mappedBy = "paymentType")
    @JsonIgnore
    private List<Invoice> invoices;

}
