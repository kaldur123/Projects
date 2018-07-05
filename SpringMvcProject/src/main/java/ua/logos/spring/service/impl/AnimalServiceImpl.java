package ua.logos.spring.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.logos.spring.entity.Animal;
import ua.logos.spring.repository.AnimalRepository;
import ua.logos.spring.service.AnimalService;

@Service
public class AnimalServiceImpl implements AnimalService {

    @Autowired private AnimalRepository animalRepository;

    @Override
    public void saveAnimal(Animal animal) {
        animalRepository.save(animal);
    }

    @Override
    public Animal findAnimalById(int id) {
        return animalRepository.getOne(id);
    }

    @Override
    public List<Animal> findAllAnimals() {
        return animalRepository.findAll();
    }

    @Override
    public Animal findAnimalByName(String name) {
        return animalRepository.findAnimalByName(name);
    }

    @Override
    public List<Animal> findAnimalsByKind(String kind) {
        return animalRepository.findAnimalsByKind(kind);
    }

    @Override
    public List<Animal> findAnimalsByGender(String gender) {
        return animalRepository.findAnimalsByGender(gender);
    }

    @Override
    public void deleteAnimalById(int id) {
        animalRepository.deleteById(id);
    }
}
