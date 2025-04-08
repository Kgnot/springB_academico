package com.frenos_el_control.principal.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class InvoiceItemDTO {
    private int itemId;
    private int productId;
    private int quantity;
    private BigDecimal price;

}
