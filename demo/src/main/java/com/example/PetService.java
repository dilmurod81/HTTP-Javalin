package com.example;

import java.util.ArrayList;
import java.util.List;

public class PetService {
    List<Pet> allPets;
    public PetService(){
        allPets = new ArrayList<>();
    }
    public List<Pet> getAllPets(){
        return allPets;
    }
    public void insertPet(Pet pet){
        allPets.add(pet);
    }
    public Pet getPetByName(String petName){
        Pet matchingPet = null;
        for(int i = 0; i < allPets.size(); i++){
            Pet currPet = allPets.get(i);
            if (currPet.getName().equals(petName)){
                matchingPet = currPet;
            }
        }
        return matchingPet;
    }
}
