package hospital.service;

import hospital.entity.Pet;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public interface PetService {

    void savePet(Pet pet, Long id) throws IOException;

    Pet findPetById(Long id);

    List<Pet> findAll();

    List<Pet> findPetsByUserId(Long id);

    void updatePet(String type, int age, String name, String color, int weight, Long id);

    void updateImg(byte[] image, Long id);

    void deletePet(Pet pet);
}
