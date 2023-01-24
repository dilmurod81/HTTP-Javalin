package com.example;

public class Pet {
    String name;
    String species;
    // we need empty constructor to work with no-args JSON
    public Pet(){

    }
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getSpecies(){
        return species;
    }
    public void setSpecies(String species){
        this.species = species;
    }

}

