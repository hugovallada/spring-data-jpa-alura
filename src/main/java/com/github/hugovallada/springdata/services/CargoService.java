package com.github.hugovallada.springdata.services;

import com.github.hugovallada.springdata.entities.Cargo;
import com.github.hugovallada.springdata.repositories.CargoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class CargoService {

    private final CargoRepository cargoRepository;

    @Autowired
    public CargoService(CargoRepository cargoRepository){
        this.cargoRepository = cargoRepository;
    }

    @Transactional
    public Cargo cadastrar(Cargo cargo){
        return cargoRepository.save(cargo);
    }

    @Transactional
    public Cargo atualizar(Cargo cargo, Long id) {
        Optional<Cargo> cargoDb = cargoRepository.findById(id);
        if(cargoDb.isEmpty()) throw new EntityNotFoundException("Não existe");

        Cargo cargoAtualizado = cargoDb.get();
        cargoAtualizado.setDescricao(cargo.getDescricao());

        return cargoRepository.save(cargoAtualizado);
    }

    public List<Cargo> listarTodos(){
        return (List<Cargo>) cargoRepository.findAll();
    }

    public void deletar(Long id){
        cargoRepository.deleteById(id);
    }
}
