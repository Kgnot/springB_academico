package com.frenos_el_control.principal.service.__db2.purchaseHistory;

import com.frenos_el_control.principal.dao.db2.PurchaseHistoryRepository;
import com.frenos_el_control.principal.entity.DB2.PurchaseHistoryPrice;
import com.frenos_el_control.principal.exception.HistoryPriceException;
import com.frenos_el_control.principal.service.__db2.historyService.HistoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.sql.Date;

@Service
@RequiredArgsConstructor
public class PurchaseHistoryServiceImpl implements HistoryService<PurchaseHistoryPrice> {

    private final PurchaseHistoryRepository repository;

    @Override
    public Page<PurchaseHistoryPrice> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public Page<PurchaseHistoryPrice> findHistoryPricesByInventory(int saleInventory, Pageable pageable) {
        return repository.findByInventoryId_inventoryId(saleInventory,pageable);
    }

    @Override
    public Page<PurchaseHistoryPrice> findHistoryPricesByDatePriceBetween(Date start, Date finish, Pageable pageable) {
        return repository.findHistoryPricesByDatePriceBetween(start, finish,pageable);
    }

    @Override
    public PurchaseHistoryPrice findById(int id) throws HistoryPriceException {
        return repository.findById(id).orElseThrow(HistoryPriceException::new);
    }

    @Override
    public PurchaseHistoryPrice save(PurchaseHistoryPrice h_price) {
        return repository.save(h_price);
    }

    @Override
    public boolean deleteById(int id) {
        repository.deleteById(id);
        return !repository.existsById(id);
    }
}
