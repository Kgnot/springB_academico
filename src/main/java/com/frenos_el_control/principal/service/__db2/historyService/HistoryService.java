package com.frenos_el_control.principal.service.__db2.historyService;
import com.frenos_el_control.principal.exception.HistoryPriceException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.sql.Date;

public interface HistoryService<T> {

    Page<T> findAll( Pageable pageable);

    // Repository impl
    Page<T> findHistoryPricesByInventory(int inventoryId, Pageable pageable);

    Page<T> findHistoryPricesByDatePriceBetween(Date start, Date finish, Pageable pageable);

    // continue...
    // puede ser que nunca lo use
    T findById(int id) throws HistoryPriceException;

    T save(T h_price);

    boolean deleteById(int id);

}
