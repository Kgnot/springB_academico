package com.frenos_el_control.principal.service.__jasperreport;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class InvoiceDetail {
    private int item;
    private String productCode;
    private String description;
    private Integer quantity;
    private Double unityValue;
    private Double total;

    public InvoiceDetail(int item, String productCode, String description, int quantity, BigDecimal unityValue) {
        this.item = item;
        this.productCode = productCode;
        this.description = description;
        this.quantity = quantity;
        this.unityValue = unityValue.doubleValue();
        this.total = unityValue.multiply(BigDecimal.valueOf(quantity)).doubleValue();
    }

}
