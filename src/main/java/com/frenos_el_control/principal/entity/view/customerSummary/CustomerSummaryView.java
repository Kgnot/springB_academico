package com.frenos_el_control.principal.entity.view.customerSummary;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerSummaryView {
    private String customerName;
    private Integer invoiceCount;
    private BigDecimal total;
    private String mostPurchaseItem;

}
