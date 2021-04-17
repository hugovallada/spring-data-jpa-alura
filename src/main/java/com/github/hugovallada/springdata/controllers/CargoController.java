package com.github.hugovallada.springdata.controllers;

import com.github.hugovallada.springdata.entities.Cargo;
import com.github.hugovallada.springdata.repositories.CargoRepository;
import com.github.hugovallada.springdata.services.CargoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
