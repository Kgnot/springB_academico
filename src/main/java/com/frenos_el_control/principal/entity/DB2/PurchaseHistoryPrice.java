package com.frenos_el_control.principal.entity.DB2;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.sql.Date;

@Entity
@Table(name = "PURCHASEHISTORYPRICE")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PurchaseHistoryPrice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "purchase_history_id")
    private int purchaseHistoryId;
    @ManyToOne
    @JoinColumn(name = "inventory_id")
    private Inventory inventoryId;
    @Column(name = "price",nullable = false)
    private BigDecimal price;
    @Column(name = "date_price",nullable = false)
    private Date datePrice;
}
