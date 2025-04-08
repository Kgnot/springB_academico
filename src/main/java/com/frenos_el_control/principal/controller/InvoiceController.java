package com.frenos_el_control.principal.controller;

import com.frenos_el_control.principal.dto.InvoiceDTO;
import com.frenos_el_control.principal.dto.InvoiceItemDTO;
import com.frenos_el_control.principal.entity.Invoice;
import com.frenos_el_control.principal.mapper.service.MapperService;
import com.frenos_el_control.principal.service.invoice.InvoiceService;
import com.frenos_el_control.principal.service.invoiceItem.InvoiceItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@RestController
@RequestMapping("/invoice")
@RequiredArgsConstructor
public class InvoiceController {

    private final InvoiceService service;
    private final InvoiceItemService invoiceItemService;
    private final MapperService mapperService;

    @GetMapping()
    public Page<Invoice> findAll(@PageableDefault(size = 30) Pageable pageable) {
        return service.findAll(pageable);
    }

    @GetMapping("/customer/{id}")
    public Page<Invoice> getInvoicesByCustomerId(@PageableDefault(size = 30) Pageable pageable, @PathVariable Integer id) {
        return service.findByCustomerId(id, pageable);
    }

    @GetMapping("/date/{date}")
    public List<Invoice> getInvoicesByDate(@PathVariable Date date) {
        return service.findByDateOrdered(date);
    }

    @GetMapping("/vehicle/{id}")
    public Page<Invoice> getInvoicesByVehicle(@PathVariable Integer id, @PageableDefault(size = 30) Pageable pageable) {
        return service.findByVehicle(id, pageable);
    }

    // vamos a obtener los filtros por mes

    // Ahora las Invoices solas:

    @GetMapping("/{id}")
    public Invoice getInvoiceById(@PathVariable int id) {
        return service.findById(id);
    }

    @PostMapping()
    public Invoice saveInvoice(@RequestBody InvoiceDTO invoice) {
        AtomicInteger index = new AtomicInteger(1);
        Invoice in = mapperService.toEntity(invoice);
        // guardamos la factura:
        in = service.save(in);
        if (in == null) throw new RuntimeException("No se pudo guardar la factura");
        //Ahora creamos los items de esa factura
        Invoice finalIn = in;
        in.getInvoiceItems().forEach(item -> {
            InvoiceItemDTO itDTO = mapperService.toDTO(item);
            invoiceItemService.save(itDTO, finalIn.getInvoiceId(), index.getAndIncrement());
        });
        return in;
    }

    @DeleteMapping("/{id}")
    public void deleteInvoice(@PathVariable int id) {
        service.deleteById(id);
    }

}
