package com.github.hugovallada.springdata.services;

import com.github.hugovallada.springdata.entities.Cargo;
import com.github.hugovallada.springdata.repositories.CargoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CargoService {

    private final CargoRepository cargoRepository;

    @Autowired
    public CargoService(CargoRepository cargoRepository){
        this.cargoRepository = cargoRepository;
    }

    public Cargo cadastrar(Cargo cargo){
        return cargoRepository.save(cargo);
    }
}
