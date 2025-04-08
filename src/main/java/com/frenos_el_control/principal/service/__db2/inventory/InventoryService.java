package com.frenos_el_control.principal.service.__db2.inventory;

import com.frenos_el_control.principal.entity.DB2.Inventory;
import com.frenos_el_control.principal.exception.InventoryException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface InventoryService {

    Page<Inventory> findAll(Pageable pageable);

    //   Methods by inventoryRepository
    Page<Inventory> findInventoriesByBrandCarId(String brand, Pageable pageable);

    Page<Inventory> findInventoriesByCarType(String type, Pageable pageable);

    // Seguimos

    Inventory findById(int id) throws InventoryException;

    Inventory save(Inventory inventory);

    boolean deleteById(int id);

}
