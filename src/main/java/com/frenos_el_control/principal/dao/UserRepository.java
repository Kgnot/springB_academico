package com.frenos_el_control.principal.dao;

import com.frenos_el_control.principal.entity.user.UserFEC;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserFEC,Integer> {

    UserFEC findByName(String name);
}
