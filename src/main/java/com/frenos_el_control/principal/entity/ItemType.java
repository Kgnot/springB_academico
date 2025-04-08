package com.frenos_el_control.principal.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "ITEMTYPE")
public class ItemType {
    @Id
    @Column(name = "item_type")
    private String itemType;
    @OneToMany(mappedBy = "itemType")
    @JsonIgnore
    private List<Item> itemList;
}
