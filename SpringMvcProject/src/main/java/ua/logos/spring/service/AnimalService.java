package ua.logos.spring.service;

import ua.logos.spring.entity.Animal;

import java.util.List;

public interface AnimalService {
    void saveAnimal(Animal animal);

    Animal findAnimalById(int id);

    List<Animal> findAllAnimals();

    Animal findAnimalByName(String name);

    List<Animal> findAnimalsByKind(String kind);

    List<Animal> findAnimalsByGender(String gender);

    void deleteAnimalById(int id);
}
