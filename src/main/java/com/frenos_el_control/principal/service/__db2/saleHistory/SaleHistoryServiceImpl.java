package com.frenos_el_control.principal.service.__db2.saleHistory;

import com.frenos_el_control.principal.dao.db2.SaleHistoryRepository;
import com.frenos_el_control.principal.entity.DB2.SaleHistoryPrice;
import com.frenos_el_control.principal.exception.HistoryPriceException;
import com.frenos_el_control.principal.service.__db2.historyService.HistoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.sql.Date;

@Service
@RequiredArgsConstructor
public class SaleHistoryServiceImpl implements HistoryService<SaleHistoryPrice> {

    private final SaleHistoryRepository repository;

    @Override
    public Page<SaleHistoryPrice> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public Page<SaleHistoryPrice> findHistoryPricesByInventory(int saleInventory, Pageable pageable) {
        return repository.findByInventoryId_inventoryId(saleInventory,pageable);
    }

    @Override
    public Page<SaleHistoryPrice> findHistoryPricesByDatePriceBetween(Date start, Date finish, Pageable pageable) {
        return repository.findHistoryPricesByDatePriceBetween(start, finish,pageable);
    }

    @Override
    public SaleHistoryPrice findById(int id) throws HistoryPriceException {
        return repository.findById(id).orElseThrow(HistoryPriceException::new);
    }

    @Override
    public SaleHistoryPrice save(SaleHistoryPrice h_price) {
        return repository.save(h_price);
    }

    @Override
    public boolean deleteById(int id) {
        repository.deleteById(id);
        return !repository.existsById(id);
    }
}
