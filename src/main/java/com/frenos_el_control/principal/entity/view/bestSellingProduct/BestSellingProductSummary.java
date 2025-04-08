package com.frenos_el_control.principal.entity.view.bestSellingProduct;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BestSellingProductSummary {
    private String product;
    private BigDecimal total;
    private Integer quantitySold;
    private String topCostumer;
    private Integer quantityPurchaseCostumer;
    private Double percentageSell;

}
