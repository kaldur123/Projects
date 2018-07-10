package project.service;

import project.entity.Dino;

import java.util.List;

public interface DinoService {

    void saveDino(Dino dino);

    Dino findById(Long id);

    Dino findDinoById(Long id);

    Dino findDinoByName(String name);

    List<Dino> findAll();

    List<String> findDinoByKind(String kind);

    List<String> findDinoKind();
}
