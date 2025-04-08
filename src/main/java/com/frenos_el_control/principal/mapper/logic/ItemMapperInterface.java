package com.frenos_el_control.principal.mapper.logic;

import com.frenos_el_control.principal.dto.InvoiceItemDTO;
import com.frenos_el_control.principal.entity.InvoiceItem;

public interface ItemMapperInterface extends GenericMapper<InvoiceItem, InvoiceItemDTO> {
    InvoiceItem toEntity(InvoiceItemDTO dto, int invoiceId, int index);
}