package com.frenos_el_control.principal.entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.frenos_el_control.principal.entity.itemKey.InvoiceItemPK;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Table(name = "INVOICEITEM")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class InvoiceItem {
    @EmbeddedId
    private InvoiceItemPK id;
    @ManyToOne
    @JoinColumn(name = "invoice_id",insertable = false, updatable = false) //Mirar que es
    @JsonBackReference(value = "invoice-items")
    private Invoice invoice;

    @Column(name = "quantity", nullable = false)
    private int quantity;
    @Column(name = "price", nullable = false)
    private BigDecimal price;
    @ManyToOne
    @JoinColumn(name = "item_id", nullable = false)
    @JsonBackReference
    private Item item;
}
