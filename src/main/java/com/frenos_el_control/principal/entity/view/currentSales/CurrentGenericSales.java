package com.frenos_el_control.principal.entity.view.currentSales;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CurrentGenericSales {
    private Integer id;
    private BigDecimal total;
    private BigDecimal prcnt;
}

