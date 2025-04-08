package com.frenos_el_control.principal.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "ITEM")
@Builder
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "item_id")
    private int itemId;
    @ManyToOne
    @JoinColumn(name = "item_type")
    private ItemType itemType;
    @Column(name = "code",length = 15)
    private String code;
    @Column(name = "description",nullable = false,unique = true)
    private String description;

    // relación one to many
    @OneToMany(mappedBy = "item")
    @JsonIgnore
    private List<InvoiceItem> invoiceItemList;

}
