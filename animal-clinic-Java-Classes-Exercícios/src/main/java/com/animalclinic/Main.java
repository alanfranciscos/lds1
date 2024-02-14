package com.animalclinic;

import java.util.ArrayList;
import java.util.Scanner;

import com.animalclinic.model.animal.giraffe.GiraffeInput;
import com.animalclinic.model.animal.horse.HorseInput;
import com.animalclinic.service.AnimalService;
import com.animalclinic.utils.Options;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inputName = "";
        boolean run = true;

        while(run) {
            System.out.print("Insira uma das opções: \n" +
            "1.	Cadastrar cavalo \n" +
            "2.	Cadastrar girafa \n" +
            "3.	Listar cavalos \n" +
            "4.	Listar girafas \n" +
            "5.	Listar todos os animais \n" +
            "6.	Remover um animal por id \n" +
            "7.	Exibir a quantidade de animais cadastrados por tipo \n" +
            "8.	Sair \n");
            int inputOption = scanner.nextInt();
            Options option = Options.fromValor(inputOption);
            
            switch (option) {
                case ADD_HORSE: //1
                    System.out.print("Insira o nome do Cavalo :");
                    inputName = scanner.next();
                    AnimalService.horseRegister(new HorseInput(inputName));
                    System.out.println("O cavalo foi inserido com sucesso");
                    break;
                case ADD_GIRAFFE: //2
                    System.out.print("Insira o nome da Girafa: ");
                    inputName = scanner.next();
                    AnimalService.giraffeRegister(new GiraffeInput(inputName));
                    System.out.println("A girafa foi inserida com sucesso.");
                    break;
                case LIST_HORSES: //3
                    AnimalService.listHorses().forEach(animal -> System.out.println(animal));
                    break;
                case LIST_GIRAFFES: //4
                    AnimalService.listGiraffes().forEach(animal -> System.out.println(animal));
                    break;
                case LIST_ANIMALS: //5
                    AnimalService.listAnimals().forEach(
                        animalHeader -> System.out.println(
                            animalHeader.getType() + " | " + animalHeader.getAnimal().getId() +  " | "  +
                            animalHeader.getAnimal().getNome()
                            ) 
                        );
                    break;
                case REMOVE_ANIMAL_BY_ID: //6
                    System.out.print("Insira o id do animal que deseja remover: ");
                    String id = scanner.next();
                    boolean removed = AnimalService.removeAnimalById(id);
                    if (removed) {
                        System.out.println("O animal foi removido com sucesso.");
                    } else {
                        System.out.println("O animal não foi encontrado.");
                    }
                    break;
                case SHOW_QUANTITY_OF_ANIMALS_BY_TYPE: //7
                    ArrayList<String> horses = AnimalService.listHorses();
                    ArrayList<String> giraffes = AnimalService.listGiraffes();
                    System.out.println("Número de cavalos cadastrados: " + horses.size());
                    horses.forEach(animal -> System.out.println(" - " + animal));
                    System.out.println("Número de girafas cadastradas: " + giraffes.size());
                    giraffes.forEach(animal -> System.out.println(" - " + animal));
                    System.out.println(
                    "Total de animais cadastrados: " + (horses.size() + giraffes.size())
                    );
                    break;
                case EXIT: //8
                    System.out.println("Saindo...");
                    run = false;
                    break;
                default:
                    break;
            }
        }
        scanner.close();
    }
}