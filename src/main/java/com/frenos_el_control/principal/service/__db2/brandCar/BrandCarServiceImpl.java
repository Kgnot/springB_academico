package com.frenos_el_control.principal.service.__db2.brandCar;

import com.frenos_el_control.principal.dao.db2.BrandCarRepository;
import com.frenos_el_control.principal.entity.DB2.BrandCar;
import com.frenos_el_control.principal.exception.BrandCarException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BrandCarServiceImpl implements BrandCarService{

    private final BrandCarRepository repository;

    @Override
    public List<BrandCar> findAll() {
        return repository.findAll();
    }

    @Override
    public BrandCar findById(String id) throws BrandCarException {
        Optional<BrandCar> op = repository.findById(id);

        return op.orElseThrow(BrandCarException::new);
    }

    @Override
    public BrandCar save(BrandCar brand) {
        return repository.save(brand);
    }

    @Override
    public boolean deleteById(String brandId) {
        repository.deleteById(brandId);
        return !repository.existsById(brandId);
    }
}

// TODO Toca cambiar el delete en todos los nuevos , ya que al eliminar solo debemos pasar el id xd no el objeto