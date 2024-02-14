package com.animalclinic.model.animal;

import java.util.UUID;

public abstract class Animal {
    private final UUID id;
    private String nome;

    public Animal(UUID id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public String getId() {
        return id.toString();
    }

    public String getNome() {
        return nome;
    }
}
