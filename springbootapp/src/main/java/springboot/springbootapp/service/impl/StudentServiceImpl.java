package springboot.springbootapp.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import springboot.springbootapp.dto.filter.SimpleFilter;
import springboot.springbootapp.entity.Student;
import springboot.springbootapp.exception.StudentNotFoundException;
import springboot.springbootapp.repository.StudentRepository;
import springboot.springbootapp.service.StudentService;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public void saveStudent(Student student) {
        studentRepository.save(student);
    }

    @Override
    public List<Student> showStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Student showStudentById(int id) {
        return studentRepository.findById(id).orElseThrow(() -> new StudentNotFoundException("Student with [" + id + "] not found"));
    }

    @Override
    public List<Student> findStudentsByFilter(SimpleFilter filter) {
        return studentRepository.findAll(getSpecification(filter));
    }

    private Specification<Student> getSpecification(SimpleFilter filter) {
        return new Specification<Student>() {
            @Override
            public Predicate toPredicate(Root<Student> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                if (filter.getSearch().isEmpty()) {
                    return null;
                }

                return criteriaBuilder.like(root.get("firstName"), "%" + filter.getSearch() + "%");
            }
        };
    }

    @Override
    public Page<Student> findStudentByPage(Pageable pageable) {
        //PageRequest pageRequest = new PageRequest(page, size);

        return studentRepository.findAll(PageRequest.of(pageable.getPageNumber(), pageable.getPageSize()));
    }
}
