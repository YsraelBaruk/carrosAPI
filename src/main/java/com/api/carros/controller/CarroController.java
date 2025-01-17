package com.api.carros.controller;

import com.api.carros.dto.CarroDTO;
import com.api.carros.model.Carro;
import com.api.carros.service.CarroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/carros")
public class CarroController {
    @Autowired
    private CarroService service;

    @GetMapping
    public ResponseEntity<List<CarroDTO>> listar(){
        var allCarros = service.listarTudo();
        var carrosDTO = allCarros.stream()
                .map(carro -> new CarroDTO(carro.getId(), carro.getModel(), carro.getNome(), carro.getDescription()))
                .toList();
        return ResponseEntity.ok(carrosDTO);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Carro> criar(@RequestBody CarroDTO carroDTO) {
        Carro car = new Carro(carroDTO);
        var newCar = service.criar(car);
        return ResponseEntity.ok().build();
    }
}
