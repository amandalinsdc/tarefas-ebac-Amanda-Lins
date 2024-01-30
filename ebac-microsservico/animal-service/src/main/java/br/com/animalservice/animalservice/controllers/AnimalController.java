package br.com.animalservice.animalservice.controllers;

import br.com.animalservice.animalservice.dto.RescuedAnimals;
import br.com.animalservice.animalservice.entities.Animal;
import br.com.animalservice.animalservice.repositories.AnimalRepository;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;

@RestController
@RequestMapping("/animais")
public class AnimalController {
    private AnimalRepository repository;

    public AnimalController(AnimalRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    private List<Animal> findAll() {
        return repository.findAll();
    }

    @PostMapping
    private Animal crete(@RequestBody Animal animal) {
        return repository.save(animal);
    }

    @GetMapping("/not-adopter")
    private List<Animal> findAllNotAdopter() {
        return repository.findNotAdopter();
    }

    @GetMapping("/adopter")
    private List<Animal> findAllAdopter() {
        return repository.findAdopter();
    }

    @GetMapping("/rescued-animals")
    private List<RescuedAnimals> findAllRescuedAnimalsByReceptor(@RequestParam Date date) {
        return repository.findRescueAnimalsByReceptor(date);
    }
}

