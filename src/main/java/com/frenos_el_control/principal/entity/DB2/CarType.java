package com.frenos_el_control.principal.entity.DB2;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "CARTYPE")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CarType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "car_type_id")
    private int carTypeId;

    @Column(name = "type")
    private String type;

    // relations:
    @OneToMany(mappedBy = "carType")
    @JsonIgnore
    private List<Inventory> inventoryList;
}
