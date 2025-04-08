package com.frenos_el_control.principal.service.user;

import com.frenos_el_control.principal.entity.user.UserFEC;

import java.util.List;

public interface UserService {

    List<UserFEC> findAll();
    UserFEC findByName(String name);

    UserFEC save(UserFEC userFEC);

}
