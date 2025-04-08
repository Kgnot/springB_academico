package com.frenos_el_control.principal.controller;


import com.frenos_el_control.principal.entity.Item;
import com.frenos_el_control.principal.service.item.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/item")
@RequiredArgsConstructor
public class ItemController {

    private final ItemService service;

    @GetMapping()
    public Page<Item> getProducts(@PageableDefault(size = 30) Pageable pageable){
        return service.findAll(pageable);
    }

    @GetMapping("/description/letter/{letter}")
    public List<Item> getByDescriptionStartingWith(@PathVariable String letter) {
        return service.findByDescriptionStartingWith(letter);
    }
    @GetMapping("/description/contain/{word}")
    public List<Item> getByDescriptionContaining(@PathVariable String word) {
        return service.findByDescriptionContaining(word);
    }

    @GetMapping("/description/{description}")
    public Item getByDescription(@PathVariable String description) {
        return service.findByDescription(description);
    }

    @GetMapping("/type/{type}")
    public List<Item> getByItemType(@PathVariable String type){ return service.findByItemType_itemType(type);}

    // Apartado de Añadir Products

    @PostMapping
    public Item addProduct(@RequestBody Item item){
        System.out.println(item);
        return service.save(item);
    }

    // Editar un producto
    @PutMapping()
    public Item editProduct(@RequestBody Item product){
        return service.save(product);
    }

}
