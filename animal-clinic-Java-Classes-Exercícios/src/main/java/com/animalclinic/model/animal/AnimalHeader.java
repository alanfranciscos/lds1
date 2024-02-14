package com.animalclinic.model.animal;

public class AnimalHeader {
    private Animal animal;
    private String type;

    public AnimalHeader(Animal animal, String type) {
        this.animal = animal;
        this.type = type;
    }

    public Animal getAnimal() {
        return animal;
    }

    public String getType() {
        return type;
    }
}
