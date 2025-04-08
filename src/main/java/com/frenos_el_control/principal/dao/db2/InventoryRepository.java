package com.frenos_el_control.principal.dao.db2;

import com.frenos_el_control.principal.entity.DB2.Inventory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InventoryRepository extends JpaRepository<Inventory,Integer> {

    Page<Inventory> findInventoriesByBrandCar_brandCarId(String brand,Pageable pageable);
    Page<Inventory> findInventoriesByCarType_type(String type,Pageable pageable);

}
