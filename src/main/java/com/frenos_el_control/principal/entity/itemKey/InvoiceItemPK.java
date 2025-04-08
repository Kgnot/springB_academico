package com.frenos_el_control.principal.entity.itemKey;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.*;

import java.io.Serializable;

@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Builder
public class InvoiceItemPK implements Serializable {
    @Column(name = "invoice_id")
    private int invoiceId;
    @Column(name = "invoice_item_id")
    private int InvoiceItemId;

}
