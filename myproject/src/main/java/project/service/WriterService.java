package project.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import project.dto.filters.UserFilter;
import project.entity.Enums.UserRole;
import project.entity.Writer;

import java.util.List;

public interface WriterService {

    void saveWriter(Writer writer);

    void deleteWriter(Writer writer);

    Writer findById(Long id);

    Writer getById(Long id);

    List<Writer> findAll();

    List<Writer> findWritersByFilter(UserFilter userFilter);

    Page<Writer> findWritersByPage(Pageable pageable);

    Page<Writer> findWritersByPage(UserFilter userFilter, Pageable pageable);

    Writer findByEmail(String email);

    List<Writer> findUsersByRole(UserRole role);

    void updateWriter(String fullName, int age, String country, Long id);

    void updateImage(String url, Long id);
}
