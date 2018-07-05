package project.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import project.entity.Enums.UserRole;
import project.entity.Writer;
import project.exception.UserNotFoundException;
import project.repository.WriterRepository;
import project.service.WriterService;

import java.util.List;

@Service
public class WriterServiceImpl implements WriterService {

    @Autowired private WriterRepository writerRepository;

    @Autowired private PasswordEncoder passwordEncoder;

    @Override
    public void saveWriter(Writer writer) {
        String pass = writer.getPassword();
        writer.setPassword(passwordEncoder.encode(pass));
        writerRepository.save(writer);
    }

    @Override
    public void deleteWriter(Writer writer) {
        writerRepository.delete(writer);
    }

    @Override
    public Writer findById(Long id) {
        return writerRepository.findById(id).orElseThrow(() -> new UserNotFoundException("User with id [" + id + "] not found"));
    }

    @Override
    public Writer getById(Long id) {
        return writerRepository.getOne(id);
    }

    @Override
    public List<Writer> findAll() {
        return writerRepository.findAll();
    }

    @Override
    public Writer findByEmail(String email) {
        return writerRepository.findByEmail(email);
    }

    @Override
    public List<Writer> findUsersByRole(UserRole role) {
        return writerRepository.findUsersByRole(role);
    }

    @Override
    public void updateWriter(String fullName, int age, String country, Long id) {
        writerRepository.updateUser(fullName, age, country, id);
    }

    @Override
    public void updateImage(String url, Long id) {
        writerRepository.updateImage(url, id);
    }
}
