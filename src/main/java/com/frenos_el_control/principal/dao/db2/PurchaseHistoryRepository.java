package com.frenos_el_control.principal.dao.db2;

import com.frenos_el_control.principal.entity.DB2.PurchaseHistoryPrice;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.sql.Date;

public interface PurchaseHistoryRepository extends JpaRepository<PurchaseHistoryPrice,Integer> {
    Page<PurchaseHistoryPrice> findByInventoryId_inventoryId(int inventoryId, Pageable pageable);
    Page<PurchaseHistoryPrice> findHistoryPricesByDatePriceBetween(Date start, Date finish, Pageable pageable);
}
