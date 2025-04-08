package com.frenos_el_control.principal.entity.DB2;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "BRANDCAR",schema = "dbo")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BrandCar { // TODO todo esto puedo manejarlo sin el Ignore si no con las manejadas :D

    @Id
    @Column(name = "brand_car_id")
    private String brandCarId;

    @OneToMany(mappedBy = "brandCar")
    @JsonIgnore
    private List<Inventory> inventoryList;
}
