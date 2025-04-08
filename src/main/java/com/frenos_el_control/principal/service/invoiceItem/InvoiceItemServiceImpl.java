package com.frenos_el_control.principal.service.invoiceItem;

import com.frenos_el_control.principal.dao.InvoiceItemRepository;
import com.frenos_el_control.principal.dto.InvoiceItemDTO;
import com.frenos_el_control.principal.entity.InvoiceItem;
import com.frenos_el_control.principal.entity.itemKey.InvoiceItemPK;
import com.frenos_el_control.principal.mapper.service.MapperService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
@Service
@RequiredArgsConstructor
public class InvoiceItemServiceImpl implements InvoiceItemService {

    private final InvoiceItemRepository repository;
    private final MapperService mapperService;

    @Override
    public InvoiceItem findById(InvoiceItemPK id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public InvoiceItem save(InvoiceItemDTO invoiceItemDTO, int invoiceId, int index) {
        //Aquí nosotros hacemos la conversión :D
        InvoiceItem it = mapperService.toEntity(invoiceItemDTO, invoiceId,index);
        return repository.save(it);
    }

    @Override
    public void deleteById(InvoiceItemPK id) {
        repository.deleteById(id);
    }
}
