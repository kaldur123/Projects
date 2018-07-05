package springboot.springbootapp.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springboot.springbootapp.entity.LoadFile;
import springboot.springbootapp.repository.LoadFileRepository;
import springboot.springbootapp.service.LoadFileInterface;

@Service
public class LoadFileServiceImpl implements LoadFileInterface {

    @Autowired
    LoadFileRepository loadFileRepository;

    @Override
    public void save(LoadFile file) {
        loadFileRepository.save(file);
    }

    @Override
    public LoadFile findOneById(int id) {
        return loadFileRepository.getOne(id);
    }
}
