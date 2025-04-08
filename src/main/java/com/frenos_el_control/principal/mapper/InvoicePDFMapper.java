package com.frenos_el_control.principal.mapper;

import com.frenos_el_control.principal.entity.Invoice;
import com.frenos_el_control.principal.service.__jasperreport.InvoiceDetail;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class InvoicePDFMapper {

    public static List<InvoiceDetail> getInvoiceDetail(Invoice invoice) {
        return invoice.getInvoiceItems().stream()
                .map(item -> InvoiceDetail.builder()
                        .item(item.getId().getInvoiceItemId())
                        .productCode(item.getItem().getCode())
                        .description(item.getItem().getDescription())
                        .quantity(item.getQuantity())
                        .unityValue(item.getPrice().doubleValue())
                        .total(item.getPrice().multiply(BigDecimal.valueOf(item.getQuantity())).doubleValue())
                        .build())
                .collect(Collectors.toList());
    }

    public static Map<String, Object> getParameters(Invoice invoice) {

        return Map.of(
                "imagenTaller", Objects.requireNonNull(InvoicePDFMapper.class.getResourceAsStream("/images/1LogoOriginal.png")),
                "nombreCliente", invoice.getCustomer().getName(),
                "cedulaCliente", invoice.getCustomer().getIdentify(),
                "direccionCliente", invoice.getCustomer().getAddress(),
                "telefonoCliente", invoice.getCustomer().getPhone(),
                "vehiculoCliente", invoice.getVehicle().getDescription(),
                "placaVehiculo", invoice.getVehicle().getPlate(),
                "total", String.valueOf(invoice.getTotal())
        );
    }

}
