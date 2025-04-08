package com.frenos_el_control.principal.dto;

import com.frenos_el_control.principal.entity.Customer;
import com.frenos_el_control.principal.entity.PaymentType;
import com.frenos_el_control.principal.entity.StatusInvoice;
import com.frenos_el_control.principal.entity.Vehicle;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class InvoiceDTO { // Esta es la request pedida

    private Customer customer;
    // El customer cuenta con: name, identify, direction, phone
    private Vehicle vehicle;
    //Vehiculo: vehicleId, customer, plate, description
    private PaymentType paymentType;
    private Date dateOrdered;
    private BigDecimal total;
    private List<InvoiceItemDTO> items;
    private StatusInvoice status;

}
