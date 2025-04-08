package com.frenos_el_control.principal.service.invoiceItem;

import com.frenos_el_control.principal.dto.InvoiceItemDTO;
import com.frenos_el_control.principal.entity.InvoiceItem;
import com.frenos_el_control.principal.entity.itemKey.InvoiceItemPK;

public interface InvoiceItemService {
    InvoiceItem findById(InvoiceItemPK id);
    InvoiceItem save(InvoiceItemDTO item, int invoiceId, int index);
    void deleteById(InvoiceItemPK id);
}
