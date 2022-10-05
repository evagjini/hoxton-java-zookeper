package com.zookeper.hoxtonjavazookeper;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AnimalController {

    @Autowired
    private AnimalRepository animalRepository;

    @GetMapping("/animals")
    public List<Animals> getAllAnimals() {
        return animalRepository.findAll();

    }

    @PostMapping("/animals")
    public Animals createNewAnimal(@RequestBody Animals animalsData) {
        return animalRepository.save(animalsData);
    }

    @DeleteMapping("/animals/{id}")
    public String deleteAnimal(@PathVariable Integer id) {
        animalRepository.deleteById(id);
        return "SUCCESSFULLY DELETED!";
    }

    @PatchMapping("/animals/{id}")
    public Animals updateAnimals(@RequestBody Animals animalsData, @PathVariable Integer id) {
        animalsData.id = id;
        return animalRepository.save(animalsData);
    }

}

interface AnimalRepository extends JpaRepository<Animals, Integer> {
}
