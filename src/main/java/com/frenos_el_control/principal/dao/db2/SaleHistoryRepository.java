package com.frenos_el_control.principal.dao.db2;

import com.frenos_el_control.principal.entity.DB2.SaleHistoryPrice;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.sql.Date;

public interface SaleHistoryRepository extends JpaRepository<SaleHistoryPrice,Integer> {

    Page<SaleHistoryPrice> findByInventoryId_inventoryId(int inventoryId, Pageable pageable);
    Page<SaleHistoryPrice> findHistoryPricesByDatePriceBetween(Date start, Date finish, Pageable pageable);

}
