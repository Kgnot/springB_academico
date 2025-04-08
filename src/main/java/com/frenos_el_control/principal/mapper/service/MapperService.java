package com.frenos_el_control.principal.mapper.service;

import com.frenos_el_control.principal.dto.CustomerDTO;
import com.frenos_el_control.principal.dto.InvoiceDTO;
import com.frenos_el_control.principal.dto.InvoiceItemDTO;
import com.frenos_el_control.principal.entity.Customer;
import com.frenos_el_control.principal.entity.Invoice;
import com.frenos_el_control.principal.entity.InvoiceItem;
import com.frenos_el_control.principal.mapper.logic.CustomerMapper;
import com.frenos_el_control.principal.mapper.logic.InvoiceMapper;
import com.frenos_el_control.principal.mapper.logic.ItemMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class MapperService {

    private final CustomerMapper customerMapper;
    private final ItemMapper itemMapper;
    private final InvoiceMapper invoiceMapper;

    // Apartado de Customer
    public CustomerDTO toDTO(Customer customer) {
        return customerMapper.toDTO(customer);
    }
    public Customer toEntity(CustomerDTO dto) {
        return customerMapper.toEntity(dto);
    }
    //Apartado de Invoice
    public InvoiceDTO toDTO(Invoice invoice) {
        return invoiceMapper.toDTO(invoice);
    }
    public Invoice toEntity(InvoiceDTO dto) {
        return invoiceMapper.toEntity(dto);
    }
    // Apartado de Item:
    public InvoiceItemDTO toDTO(InvoiceItem invoiceItem) {
        return itemMapper.toDTO(invoiceItem);
    }
    public InvoiceItem toEntity(InvoiceItemDTO dto, int invoiceId, int index) {
        return itemMapper.toEntity(dto,invoiceId,index);
    }

}
