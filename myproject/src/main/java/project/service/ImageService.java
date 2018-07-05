package project.service;

import project.entity.Image;

import java.util.List;

public interface ImageService {

    void saveImage(Image image);

    Image findById(Long id);

    List<Image> findAll();

    List<Image> findAllByDinoId(Long id);
}
