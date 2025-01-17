package com.api.carros.service;

import com.api.carros.dto.CarroDTO;
import com.api.carros.model.Carro;
import com.api.carros.repository.CarroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarroService {

    @Autowired
    private CarroRepository repository;

    public List<Carro> listarTudo() {
        return repository.findAllByActiveTrue();
    }

    public Carro criar(Carro car){
        return repository.save(car);
    }

    public Carro buscarId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Produto não encontrado"));
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
