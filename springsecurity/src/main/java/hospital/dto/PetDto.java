package hospital.dto;

import hospital.entity.User;
import lombok.Data;

@Data
public class PetDto {

    private String type;

    private int age;

    private String name;

    private String color;

    private int weight;

}
