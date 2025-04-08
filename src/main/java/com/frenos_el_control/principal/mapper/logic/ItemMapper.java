package com.frenos_el_control.principal.mapper.logic;

import com.frenos_el_control.principal.dto.InvoiceItemDTO;
import com.frenos_el_control.principal.entity.InvoiceItem;
import com.frenos_el_control.principal.entity.Item;
import com.frenos_el_control.principal.entity.itemKey.InvoiceItemPK;
import org.springframework.stereotype.Component;

@Component
public class ItemMapper implements ItemMapperInterface {
    @Override
    public InvoiceItemDTO toDTO(InvoiceItem invoiceItem) {
        return InvoiceItemDTO.builder()
                .itemId(invoiceItem.getId().getInvoiceItemId())
                .productId(invoiceItem.getItem().getItemId())
                .quantity(invoiceItem.getQuantity())
                .price(invoiceItem.getPrice())
                .build();
    }

    @Override
    public InvoiceItem toEntity(InvoiceItemDTO dto) {
        throw new UnsupportedOperationException("Este método no tiene sentido sin invoiceId");
    }

    @Override
    public InvoiceItem toEntity(InvoiceItemDTO dto, int invoiceId, int index) {
        InvoiceItemPK id = InvoiceItemPK.builder()
                .invoiceId(invoiceId)
                .InvoiceItemId(index)
                .build();

        return InvoiceItem.builder()
                .id(id)
                .item(Item.builder()
                        .itemId(dto.getProductId())
                        .build())
                .quantity(dto.getQuantity())
                .price(dto.getPrice())
                .build();
    }
}
