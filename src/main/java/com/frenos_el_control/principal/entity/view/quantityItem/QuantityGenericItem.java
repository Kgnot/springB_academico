package com.frenos_el_control.principal.entity.view.quantityItem;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class QuantityGenericItem {

    private String type;
    private Integer quantity_current_period;
    private Integer quantity_previous_period;
    private BigDecimal variation_percentage;

}
