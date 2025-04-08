package com.frenos_el_control.principal.entity.view.topPerformingProducts;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TopPerformingProducts {

    private String productName;
    private Integer totalQuantitySold;
    private BigDecimal totalSalesAmount;
    private Integer uniqueCustomers;
    private BigDecimal averagePurchasePrice;
}
