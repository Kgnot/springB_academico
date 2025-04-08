package com.frenos_el_control.principal.entity.view.topCustomer;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TopCustomer {
    private String customer;
    private BigDecimal totalSpent;
    private Integer totalInvoices;
    private BigDecimal averagePurchase;
    private Date lastPurchase;
    private String topType;
    private Integer totalQuantityPurchasedInTopType;
}
