package com.frenos_el_control.principal.mapper.logic;

import com.frenos_el_control.principal.dto.InvoiceDTO;
import com.frenos_el_control.principal.entity.Invoice;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class InvoiceMapper implements GenericMapper <Invoice, InvoiceDTO>{
    private final ItemMapper itemMapper;
    @Override
    public InvoiceDTO toDTO(Invoice invoice) {
        return InvoiceDTO.builder()
                .customer(invoice.getCustomer())
                .vehicle(invoice.getVehicle())
                .paymentType(invoice.getPaymentType())
                .dateOrdered(invoice.getDateOrdered())
                .status(invoice.getStatus())
                .items(invoice.getInvoiceItems().stream().map(itemMapper::toDTO).collect(Collectors.toList()))
                .total(invoice.getTotal())
                .build();
    }

    @Override
    public Invoice toEntity(InvoiceDTO dto) {
        Invoice invoice = new Invoice();
        invoice.setCustomer(dto.getCustomer());
        invoice.setVehicle(dto.getVehicle());
        invoice.setPaymentType(dto.getPaymentType());
        invoice.setDateOrdered(dto.getDateOrdered());
        invoice.setTotal(dto.getTotal());
        invoice.setStatus(dto.getStatus());
        invoice.setInvoiceItems(dto.getItems().stream()
                .map( itemDTO ->
                        itemMapper.toEntity(itemDTO, invoice.getInvoiceId(), itemDTO.getItemId())
        )
                .collect(Collectors.toList()));
        return invoice;
    }
}
