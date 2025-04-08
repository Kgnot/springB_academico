package com.frenos_el_control.principal.entity.DB2;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "INVENTORY")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Inventory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "inventory_id")
    private int inventoryId;
    @ManyToOne
    @JoinColumn(name = "car_type_id")
    private CarType carType;
    @ManyToOne
    @JoinColumn(name = "brand_car_id")
    private BrandCar brandCar;
    @Column(name = "name",nullable = false,length = 30)
    private String name;
    @Column(name = "quantity",nullable = false)
    private Integer quantity;
    @Column(name = "img_url",length = 50)
    private String imgUrl;
    @Column(name = "notes")
    private String notes;

    // relation
    @OneToMany(mappedBy = "inventoryId")
    @JsonIgnore
    private List<PurchaseHistoryPrice> purchaseHistory;
    @OneToMany(mappedBy = "inventoryId")
    @JsonIgnore
    private List<SaleHistoryPrice> saleHistory;
}
