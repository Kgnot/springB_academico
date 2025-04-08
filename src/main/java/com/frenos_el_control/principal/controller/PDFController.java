package com.frenos_el_control.principal.controller;


import com.frenos_el_control.principal.entity.Invoice;
import com.frenos_el_control.principal.mapper.InvoicePDFMapper;
import com.frenos_el_control.principal.service.__jasperreport.InvoiceDetail;
import com.frenos_el_control.principal.service.__jasperreport.JasperReportService;
import com.frenos_el_control.principal.service.invoice.InvoiceService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/pdf")
@RestController
@RequiredArgsConstructor
public class PDFController {

    private final JasperReportService jasperService;
    private final InvoiceService invoiceService;

    @GetMapping("/{id}")
    public byte[] getPDF(@PathVariable int id) {
        // Lo primero que haremos es buscar
        Invoice invoice = invoiceService.findById(id);
        List<InvoiceDetail> details = InvoicePDFMapper.getInvoiceDetail(invoice);
        //creamos los parámetros
        jasperService.setParameters(InvoicePDFMapper.getParameters(invoice));
        return jasperService.imprimirReporte(details);
    }

}
