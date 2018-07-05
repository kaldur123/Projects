package springboot.springbootapp.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import springboot.springbootapp.entity.Image;
import springboot.springbootapp.entity.User;
import springboot.springbootapp.repository.ImageRepository;
import springboot.springbootapp.service.ImageService;

@Service
public class ImageServiceImpl implements ImageService {

    @Autowired
    ImageRepository imageRepository;

    @Override
    public void saveImage(Image image) {
        imageRepository.save(image);
    }

    @Override
    public Image findById(int i) { return imageRepository.getOne(i);
    }

    @Override
    @Transactional
    public void updateImage(String name, byte[] arr, int id) {
        imageRepository.updateImage(name, arr, id);
    }

    @Override
    public Image findByUserId(int id) {
        return imageRepository.findByUserId(id);
    }

}
