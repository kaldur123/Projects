package hospital.service.impl;

import hospital.entity.Pet;
import hospital.repository.PetRepository;
import hospital.service.PetService;
import hospital.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

@Service
public class PetServiceImpl implements PetService {

    @Autowired private PetRepository petRepository;

    @Autowired private UserService userService;

    @Override
    public void savePet(Pet pet, Long id) throws IOException {
        pet.setUser(userService.findUserById(id));
        byte[] arr = new byte[(int) new File("D:\\default.png").length()];
        FileInputStream fileInputStream = new FileInputStream(new File("D:\\default.png"));
        fileInputStream.read(arr);
        pet.setImage(arr);
        petRepository.save(pet);
    }

    @Override
    public void deletePet(Pet pet) {
        petRepository.delete(pet);
    }

    @Override
    public Pet findPetById(Long id) {
        return petRepository.getOne(id);
    }

    @Override
    public List<Pet> findAll() {
        return petRepository.findAll();
    }

    @Override
    public List<Pet> findPetsByUserId(Long id) {
        return petRepository.findPetsByUserId(id);
    }

    @Override
    public void updatePet(String type, int age, String name, String color, int weight, Long id) {
        petRepository.updatePet(type, age, name, color, weight, id);
    }

    @Override
    public void updateImg(byte[] image, Long id) {
        petRepository.updateImg(image, id);
    }
}
