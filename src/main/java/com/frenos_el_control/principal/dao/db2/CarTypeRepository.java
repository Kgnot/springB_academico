package com.frenos_el_control.principal.dao.db2;

import com.frenos_el_control.principal.entity.DB2.CarType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarTypeRepository extends JpaRepository<CarType,Integer> {
}
