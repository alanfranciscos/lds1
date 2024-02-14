package com.animalclinic.service;

import com.animalclinic.model.animal.AnimalHeader;
import com.animalclinic.model.animal.giraffe.Giraffe;
import com.animalclinic.model.animal.giraffe.GiraffeInput;
import com.animalclinic.model.animal.horse.Horse;
import com.animalclinic.model.animal.horse.HorseInput;
import com.animalclinic.repository.FakeDb;
import com.fasterxml.uuid.Generators;
import com.fasterxml.uuid.NoArgGenerator;

import java.util.ArrayList;
import java.util.UUID;

public class AnimalService {
    private static NoArgGenerator generator = Generators.randomBasedGenerator();

    private static UUID generateUUID() {
        return generator.generate();
    }

    public static Horse horseRegister(HorseInput horseInput) {
        Horse horse = new Horse(generateUUID(), horseInput.getName());
        return (Horse) FakeDb.insertAnimal(horse);
    }

    public static Giraffe giraffeRegister(GiraffeInput giraffeInput) {
        Giraffe giraffe = new Giraffe(generateUUID(), giraffeInput.getName());
        return (Giraffe) FakeDb.insertAnimal(giraffe);
    }

    public static ArrayList<String> listHorses() {
        ArrayList<String> response = new ArrayList<>();
        FakeDb.getAnimalsList(Horse.class).forEach(
            animal -> response.add(animal.getId() + " | " + animal.getNome())
        );
        return response;
    }

    public static ArrayList<String> listGiraffes() {
        ArrayList<String> response = new ArrayList<>();
        FakeDb.getAnimalsList(Giraffe.class).forEach(
            animal -> response.add(animal.getId() + " | " + animal.getNome())
        );
        return response;
    }

    public static ArrayList<AnimalHeader> listAnimals() {
        return FakeDb.getAnimalsList();
    }

    public static boolean removeAnimalById(String id) {
        return FakeDb.removeAnimalById(id);
    }

}