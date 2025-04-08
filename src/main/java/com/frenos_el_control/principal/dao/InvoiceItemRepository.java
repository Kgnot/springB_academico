package com.frenos_el_control.principal.dao;

import com.frenos_el_control.principal.entity.InvoiceItem;
import com.frenos_el_control.principal.entity.itemKey.InvoiceItemPK;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface InvoiceItemRepository extends JpaRepository<InvoiceItem, InvoiceItemPK> {

    List<InvoiceItem> findByIdInvoiceId(int id);


}
