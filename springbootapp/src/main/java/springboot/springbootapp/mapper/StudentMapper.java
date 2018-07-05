package springboot.springbootapp.mapper;

import springboot.springbootapp.dto.StudentDto;
import springboot.springbootapp.entity.Student;

public interface StudentMapper {

    static Student studentDtoToStudent(StudentDto studentDto) {
        Student student = new Student();
        student.setFirstName(studentDto.getFirstName());
        student.setLastName(studentDto.getLastName());
        student.setAge(studentDto.getAge());
        student.setPassword(studentDto.getPassword());


        return student;
    }
}
