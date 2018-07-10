package project.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import project.dto.filters.UserFilter;
import project.entity.Enums.UserRole;
import project.entity.Writer;
import project.exception.UserNotFoundException;
import project.repository.WriterRepository;
import project.service.WriterService;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
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
    public List<Writer> findWritersByFilter(UserFilter userFilter) {
        return writerRepository.findAll(getSpecification(userFilter));
    }

    public Specification<Writer> getSpecification(UserFilter userFilter) {
        return new Specification<Writer>() {
            @Override
            public Predicate toPredicate(Root<Writer> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                if (userFilter.getSearchFullName().isEmpty()&&userFilter.getSearchAge().isEmpty()&&userFilter.getSearchEmail().isEmpty()&&userFilter.getSearchCountry().isEmpty()) {
                    return null;
                }
                if (userFilter.getSearchAge().isEmpty()) {
                    return criteriaBuilder.and(criteriaBuilder.like(root.get("fullName"), "%" + userFilter.getSearchFullName() + "%"),
                            criteriaBuilder.like(root.get("email"), "%" + userFilter.getSearchEmail() + "%"),
                            criteriaBuilder.like(root.get("country"), "%" + userFilter.getSearchCountry() + "%"));
                }
                else {
                    return criteriaBuilder.and(criteriaBuilder.like(root.get("fullName"), "%" + userFilter.getSearchFullName() + "%"),
                            criteriaBuilder.equal(root.get("age"), Integer.valueOf(userFilter.getSearchAge())),
                            criteriaBuilder.like(root.get("email"), "%" + userFilter.getSearchEmail() + "%"),
                            criteriaBuilder.like(root.get("country"), "%" + userFilter.getSearchCountry() + "%"));

                }
            }
        };
    }

    @Override
    public Page<Writer> findWritersByPage(Pageable pageable) {
        return writerRepository.findAll(PageRequest.of(pageable.getPageNumber(), pageable.getPageSize()));
    }

    @Override
    public Page<Writer> findWritersByPage(UserFilter userFilter, Pageable pageable) {
        return writerRepository.findAll(getSpecification(userFilter), PageRequest.of(pageable.getPageNumber(), userFilter.getSize()));
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
