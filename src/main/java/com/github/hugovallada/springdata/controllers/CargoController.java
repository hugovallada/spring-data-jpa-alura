package com.github.hugovallada.springdata.controllers;

import com.github.hugovallada.springdata.entities.Cargo;
import com.github.hugovallada.springdata.repositories.CargoRepository;
import com.github.hugovallada.springdata.services.CargoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cargos")
public class CargoController {

    private final CargoService cargoService;

    @Autowired
    public CargoController(CargoService cargoService) {
        this.cargoService = cargoService;
    }

    @PostMapping
    public Cargo criarCargp(@RequestBody Cargo cargo) {
        return cargoService.cadastrar(cargo);
    }

    @PutMapping("/{id}")
    public Cargo atualizarCargo(
            @RequestBody Cargo cargo,
            @PathVariable Long id
    ) {
        return cargoService.atualizar(cargo, id);
    }

    @GetMapping
    public List<Cargo> lsitarTodos(){
        return cargoService.listarTodos();
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id){
        cargoService.deletar(id);
    }


}
