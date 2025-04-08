package com.frenos_el_control.principal.service.item;

import com.frenos_el_control.principal.dao.ItemRepository;
import com.frenos_el_control.principal.entity.Item;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ItemServiceImpl implements ItemService {

    private final ItemRepository repository;
    @Override
    public Page<Item> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public Item findById(int id) {
        Optional<Item> product = repository.findById(id);
        return product.orElse(null);
    }

    @Override
    public Item findByDescription(String description) {
        return repository.findByDescription(description);
    }

    @Override
    public List<Item> findByDescriptionStartingWith(String description) {
        return repository.findByDescriptionStartingWith(description);
    }

    @Override
    public Item save(Item product) {

        return repository.save(product);
    }

    @Override
    public List<Item> findByItemType_itemType(String type) {
        return repository.findByItemType_itemType(type);
    }

    @Override
    public List<Item> findByDescriptionContaining(String type) {
        return repository.findByDescriptionContaining(type);
    }
}
