package springboot.springbootapp.service;

import springboot.springbootapp.entity.LoadFile;

public interface LoadFileInterface {

    void save(LoadFile file);

    LoadFile findOneById(int id);
}
