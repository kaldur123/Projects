package project.service;

import project.entity.Enums.UserRole;
import project.entity.Writer;

import java.util.List;

public interface WriterService {

    void saveWriter(Writer writer);

    void deleteWriter(Writer writer);

    Writer findById(Long id);

    Writer getById(Long id);

    List<Writer> findAll();

    Writer findByEmail(String email);

    List<Writer> findUsersByRole(UserRole role);

    void updateWriter(String fullName, int age, String country, Long id);

    void updateImage(String url, Long id);
}
