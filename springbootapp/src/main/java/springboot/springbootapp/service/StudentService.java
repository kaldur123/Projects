package springboot.springbootapp.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import springboot.springbootapp.dto.filter.SimpleFilter;
import springboot.springbootapp.entity.Student;

import java.util.List;
import java.util.Optional;

public interface StudentService {

    void saveStudent(Student student);

    List<Student> showStudents();

    Student showStudentById(int id);

    List<Student> findStudentsByFilter(SimpleFilter filter);

    Page<Student> findStudentByPage(Pageable pageable);

    //Optional<Student> findOptionalById(int id);
}
