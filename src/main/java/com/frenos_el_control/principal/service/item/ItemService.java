package com.frenos_el_control.principal.service.item;

import com.frenos_el_control.principal.entity.Item;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ItemService {

    Page<Item> findAll(Pageable pageable);
    Item findById(int id);
    Item findByDescription(String description);
    List<Item> findByDescriptionStartingWith(String description);
    Item save(Item product);
    List<Item> findByItemType_itemType(String type);

    List<Item> findByDescriptionContaining(String type);
}
