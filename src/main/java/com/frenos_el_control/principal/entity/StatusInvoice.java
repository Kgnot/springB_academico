package com.frenos_el_control.principal.entity;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name="STATUSINVOICE")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StatusInvoice {
    @Id
    @Column(name = "status_id", length = 15)
    private String statusId;
    @OneToMany(mappedBy = "status")
    @JsonManagedReference(value = "invoice-status")
    private List<Invoice> invoiceList;
}
