package project.mapper;

import project.dto.DinoDto;
import project.entity.Dino;

public class DinoMapper {

    public static Dino convertToDino(DinoDto dinoDto) {
        Dino dino = new Dino();
        dino.setName(dinoDto.getName());
        dino.setKind(dinoDto.getKind());
        return dino;
    }

    public static DinoDto convertToDto(Dino dino) {
        DinoDto dinoDto = new DinoDto();
        dinoDto.setName(dino.getName());
        dinoDto.setKind(dino.getKind());
        return dinoDto;
    }
}
