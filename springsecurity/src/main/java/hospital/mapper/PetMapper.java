package hospital.mapper;

import hospital.dto.PetDto;
import hospital.entity.Pet;

public class PetMapper {

    public static Pet convertToPet(PetDto petDto) {
        Pet pet = new Pet();
        pet.setType(petDto.getType());
        pet.setAge(petDto.getAge());
        pet.setName(petDto.getName());
        pet.setColor(petDto.getColor());
        pet.setWeight(petDto.getWeight());
        return pet;

    }
}
