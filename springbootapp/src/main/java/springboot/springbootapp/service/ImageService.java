package springboot.springbootapp.service;

import springboot.springbootapp.entity.Image;
import springboot.springbootapp.entity.User;

public interface ImageService {

    void saveImage(Image image);

    Image findById(int i);

    void updateImage(String name, byte[] arr, int id);

    Image findByUserId(int id);

}
