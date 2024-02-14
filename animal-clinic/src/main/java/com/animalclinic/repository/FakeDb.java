package com.animalclinic.repository;


import com.animalclinic.model.animal.Animal;
import com.animalclinic.model.animal.AnimalHeader;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class FakeDb {

    private static HashMap<String, ArrayList<Animal>> animalsList;

    public static HashMap<String, ArrayList<Animal>> getAnimals() {
        return animalsList;
    }

    public static  ArrayList<AnimalHeader> getAnimalsList() {
        HashMap<String, ArrayList<Animal>> animalsHash = FakeDb.getAnimals();
        Set<String> keys = null;
        try {
            keys = animalsHash.keySet();
        } catch (NullPointerException e) {
            return new ArrayList<>();
        }

        ArrayList<AnimalHeader> animals = new ArrayList<>();

        for(String key: keys) {
            for(Animal animal : animalsHash.get(key)) {
                AnimalHeader _animal = new AnimalHeader(animal, key);
                animals.add(_animal);
            }
        }
        return animals;

    }

    public static ArrayList<Animal> getAnimalsList(Class<?> animal) {
        String typeOfAnimal = animal.getSimpleName();
        ArrayList<Animal> animals = new ArrayList<>();
        try{
           animals = animalsList.get(typeOfAnimal);
        } catch (NullPointerException e) {
            return animals;
        }

        if (animals == null || animals.isEmpty()) {
            return new ArrayList<>();
        }
        return animalsList.get(typeOfAnimal);
    }

    public static Object getAnimalById(String id) {
        HashMap<String, ArrayList<Animal>> animalsHash = new HashMap<>();
        try { 
            animalsHash = FakeDb.getAnimals();
        } catch (NullPointerException e) {
          FakeDb.animalsList = new HashMap<>();
          animalsHash = FakeDb.getAnimals();
        }
        Set<String> keys = new HashSet<>();
        try {
            keys = animalsHash.keySet();
        } catch (NullPointerException e){
            return null;
        }
        

        for (String key : keys) {
            ArrayList<Animal> animals = animalsHash.get(key);
            for (Animal animal : animals) {
                if (animal.getId().equals(id)) {
                    return animal;
                }
            }
        }
        return null;
    }

    public static Object insertAnimal(Animal animal) {
        String animalType = animal.getClass().getSimpleName();
        boolean containsKey = false;
        try {
            containsKey = FakeDb.animalsList.containsKey(animalType);
        } catch (NullPointerException e) {
            FakeDb.animalsList = new HashMap<>();
        }

        boolean existAnimal = getAnimalById(animal.getId()) instanceof Animal;

        if (existAnimal) {
            return "Animal with FakeDb id already exist, retry, please.";
        }

        if (!containsKey) {
            ArrayList<Animal> animals = new ArrayList<>();
            animals.add(animal);
            FakeDb.animalsList.put(animalType, animals);
        } else {
            FakeDb.animalsList.get(animalType).add(animal);
        }

        return getAnimalById(animal.getId());
    }

    public static boolean removeAnimalById(String id) {
        Animal animal = (Animal) getAnimalById(id);
        if (!(animal instanceof Animal)) {
            return false;
        } 
        
        HashMap<String, ArrayList<Animal>> animalsHash = FakeDb.getAnimals();
        Set<String> keys = animalsHash.keySet();

        for (String key : keys) {
            ArrayList<Animal> animals = animalsHash.get(key);
            for (Animal _animal : animals) {
                if (_animal.getId().equals(id)) {
                    animals.remove(_animal);
                    return true;
                }
            }
        }
        return false;
    }
}