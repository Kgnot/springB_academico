package com.frenos_el_control.principal.entity.DB2;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.sql.Date;

@Entity
@Table(name = "SALEHISTORYPRICE")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SaleHistoryPrice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sale_history_id")
    private int saleHistoryId;
    @ManyToOne
    @JoinColumn(name = "inventory_id")
    private Inventory inventoryId;
    @Column(name = "price",nullable = false)
    private BigDecimal price;
    @Column(name = "date_price",nullable = false)
    private Date datePrice;

}
