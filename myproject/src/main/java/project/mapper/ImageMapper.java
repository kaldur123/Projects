package project.mapper;

import project.dto.ImageDto;
import project.entity.Image;

public class ImageMapper {

    public static Image convertToImage(ImageDto imageDto) {
        Image image = new Image();
        image.setImage(imageDto.getImage());
        return image;
    }


    public static ImageDto convertToDto(Image image) {
        ImageDto imageDto = new ImageDto();
        imageDto.setImage(image.getImage());
        return imageDto;
    }
}
