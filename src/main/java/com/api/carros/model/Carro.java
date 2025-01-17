package com.api.carros.model;

import com.api.carros.dto.CarroDTO;
import jakarta.persistence.*;

import java.math.BigDecimal;

    @Entity
    @Table(name = "carros")
    public class Carro {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @Column(name = "modelo", nullable = false)
        private String model;

        @Column(name = "nome", nullable = false)
        private String nome;

        @Column(name = "description", nullable = false)
        private String description;

        private Boolean active;

        public Carro(){}

        public Carro(Long id, String model, String nome, String description, Boolean active) {
            this.id = id;
            this.model = model;
            this.nome = nome;
            this.description = description;
            this.active = active;
        }

        public Carro(CarroDTO car) {
            this.id = car.id();
            this.model = car.model();
            this.nome = car.nome();
            this.description = car.description();
            this.active = true;
        }

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getModel() {
            return model;
        }

        public void setModel(String model) {
            this.model = model;
        }

        public String getNome() {
            return nome;
        }

        public void setNome(String nome) {
            this.nome = nome;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public Boolean getActive() {
            return active;
        }

        public void setActive(Boolean active) {
            this.active = active;
        }

        @Override
        public String toString() {
            return "Carro{" +
                    "model='" + model + '\'' +
                    ", nome='" + nome + '\'' +
                    ", description='" + description + '\'' +
                    '}';
        }
    }