package com.frenos_el_control.principal.entity;

import com.fasterxml.jackson.annotation.*;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "CUSTOMER")
@Builder
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id", nullable = false)
    private int customerId;

    @Column(name = "name", nullable = false, unique = true)
    private String name;

    @Column(name = "identify")
    private String identify;

    @Column(name = "address")
    private String address;

    @Column(name = "phone",length = 13)
    private String phone;

    // Relaciones:
    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private List<Vehicle> vehicles;
    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private List<Invoice> invoices;
}
