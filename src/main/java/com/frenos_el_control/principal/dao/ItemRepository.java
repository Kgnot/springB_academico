package com.frenos_el_control.principal.dao;

import com.frenos_el_control.principal.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ItemRepository extends JpaRepository<Item, Integer> {

    List<Item> findByDescriptionStartingWith(String description);
    List<Item> findByDescriptionContaining(String desc);
    Item findByDescription(String description);

    List<Item> findByItemType_itemType(String type);

}
