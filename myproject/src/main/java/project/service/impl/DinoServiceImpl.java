package project.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.entity.Dino;
import project.repository.DinoRepository;
import project.service.DinoService;

import java.util.List;

@Service
public class DinoServiceImpl implements DinoService {

    @Autowired private DinoRepository dinoRepository;

    @Override
    public void saveDino(Dino dino) {
        dinoRepository.save(dino);
    }

    @Override
    public Dino findById(Long id) {
        return dinoRepository.getOne(id);
    }

    @Override
    public Dino findDinoByName(String name) {
        return dinoRepository.findDinoByName(name);
    }

    @Override
    public List<Dino> findAll() {
        return dinoRepository.findAll();
    }

    @Override
    public List<String> findDinoByKind(String kind) {
        return dinoRepository.findDinoByKind(kind);
    }

    @Override
    public List<String> findDinoKind() {
        return dinoRepository.findDinoKind();
    }
}
