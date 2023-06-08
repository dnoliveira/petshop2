package br.cefet.dbf.petshop.controller;

import br.cefet.dbf.petshop.model.Pet;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/pet")
public class PetController {

    @GetMapping("/{id}")
    public Pet get(@PathVariable("id") int id){
        Pet pet = Pet.builder()
                .id(id)
                .nome("Spike")
                .dono("Gabriella")
                .raca("Vira lata")
                .build();
        return pet;
    }

    @GetMapping("")
    public List<Pet> getAll() {
        Pet pet = Pet.builder()
                .id(1)
                .nome("Spike")
                .dono("Gabriella")
                .raca("Vira lata")
                .build();
        Pet pet2 = Pet.builder()
                .id(2)
                .nome("Bidu")
                .dono("Monica")
                .build();
        List<Pet> petList = new ArrayList<>();
        petList.add(pet);
        petList.add(pet2);
        return petList;
    }

}
