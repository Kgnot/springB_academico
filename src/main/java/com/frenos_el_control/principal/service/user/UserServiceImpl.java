package com.frenos_el_control.principal.service.user;

import com.frenos_el_control.principal.dao.UserRepository;
import com.frenos_el_control.principal.entity.user.UserFEC;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {


    private final UserRepository repository;

    @Override
    public List<UserFEC> findAll() {
        return repository.findAll();
    }

    @Override
    public UserFEC findByName(String name) {
        return repository.findByName(name);
    }

    @Override
    public UserFEC save(UserFEC userFEC) {
        return repository.save(userFEC);
    }
}
