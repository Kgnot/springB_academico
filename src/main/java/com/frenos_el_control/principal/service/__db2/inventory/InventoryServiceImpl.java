package com.frenos_el_control.principal.service.__db2.inventory;

import com.frenos_el_control.principal.dao.db2.InventoryRepository;
import com.frenos_el_control.principal.entity.DB2.Inventory;
import com.frenos_el_control.principal.exception.InventoryException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class InventoryServiceImpl implements InventoryService{

    private final InventoryRepository repository;

    @Override
    public Page<Inventory> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public Page<Inventory> findInventoriesByBrandCarId(String brand, Pageable pageable) {
        return repository.findInventoriesByBrandCar_brandCarId(brand,pageable);
    }

    @Override
    public Page<Inventory> findInventoriesByCarType(String type,Pageable pageable) {
        return repository.findInventoriesByCarType_type(type,pageable);
    }

    @Override
    public Inventory findById(int id) throws InventoryException {
        return repository.findById(id).orElseThrow(InventoryException::new);
    }

    @Override
    public Inventory save(Inventory inventory) {
        return repository.save(inventory);
    }

    @Override
    public boolean deleteById(int inventory) {
        repository.deleteById(inventory);
        return !repository.existsById(inventory);
    }
}
