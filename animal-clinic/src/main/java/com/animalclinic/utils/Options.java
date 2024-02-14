package com.animalclinic.utils;

public enum Options {
    ADD_HORSE(1),
    ADD_GIRAFFE(2),
    LIST_HORSES(3),
    LIST_GIRAFFES(4),
    LIST_ANIMALS(5),
    REMOVE_ANIMAL_BY_ID(6),
    SHOW_QUANTITY_OF_ANIMALS_BY_TYPE(7),
    EXIT(8),
    DEFAULT(-1);

    private final int value;

    Options(int value){
        this.value = value;
    }

    public int getValor() {
        return this.value;
    }

    public static Options fromValor(int value) {
        for (Options number : Options.values()) {
            if (number.value == value) {
                return number;
            }
        }
        return DEFAULT;
    }
}