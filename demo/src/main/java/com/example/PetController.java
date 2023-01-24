package com.example;

import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.javalin.Javalin;

public class PetController {
    PetService petService;
    Javalin app;
    public PetController(){
        petService = new PetService();
        app = Javalin.create();
    }
    public void startAPI(){
        app.start(9002);
        
        app.get("/pet/", ctx -> 
        {
            List<Pet> pets = petService.getAllPets();
            ctx.json(pets);
        }
        );
        app.post("/pet/", ctx -> 
        {
            // Pet pet = new Pet();
            // pet.setName("Bobby");
            // pet.setSpecies("Dog");

            System.out.println(ctx.body());
            // create object mapper from jackson databind(from maven)
            ObjectMapper om = new ObjectMapper();
            Pet pet = om.readValue(ctx.body(), Pet.class);
            petService.insertPet(pet);

        }    
        );
        app.get("/pet/{name}", ctx -> 
        {
            String petName = ctx.pathParam("name");
            Pet pet = petService.getPetByName(petName);
            ctx.json(pet);
        }
        );
        // this below code will give server error 
        // app.get("bad", ctx -> {
        //     int bad = 1/0;
        // });

    }
}
