package springboot.springbootapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import springboot.springbootapp.dto.StudentDto;
import springboot.springbootapp.dto.filter.SimpleFilter;
import springboot.springbootapp.entity.Country;
import springboot.springbootapp.entity.Student;
import springboot.springbootapp.entity.StudentDetails;
import springboot.springbootapp.mapper.StudentMapper;
import springboot.springbootapp.service.CountryService;
import springboot.springbootapp.service.StudentService;

import javax.validation.Valid;

@Controller
@SessionAttributes("countries")
public class HomeController {

    private StudentService studentService;
    private CountryService countryService;

    @Autowired
    public HomeController(StudentService studentService, CountryService countryService) {
        this.studentService = studentService;
        this.countryService = countryService;
    }

    @GetMapping("/")
    public String showHome() {
        return "home";
    }

    @GetMapping("/add/country")
    public String showAddCountryForm(Model model) {
        model.addAttribute("countryModel", new Country());
        return "add-country";
    }
    @PostMapping("/add/country")
    public String saveCountry(@Valid @ModelAttribute("countryModel") Country country, BindingResult br) {
        if(br.hasErrors()) {
            return "add-country";
        }
        countryService.saveCountry(country);
        return "redirect:/";
    }

    @GetMapping("/add/student")
    public String showAddStudentForm(Model model) {
        model.addAttribute("studentModel", new Student());
        model.addAttribute("countries", countryService.showCountries());
        return "add-student";
    }

    @PostMapping("/add/student")
    public String saveStudent(@Valid @ModelAttribute("studentModel") Student student, BindingResult br) {
        if (br.hasErrors()) {
            return "add-student";
        }
        studentService.saveStudent(student);
        return "redirect:/";
    }
    //DTO
    @GetMapping("/add/student-dto")
    public String showAddStudentDtoForm(Model model) {
        model.addAttribute("studentModel", new StudentDto());

        return "add-student-dto";
    }

    @PostMapping("/add/student-dto")
    public String saveStudentDto(@ModelAttribute("studentModel") @Valid StudentDto studentDto, BindingResult br) {

        if (br.hasErrors()) {
            return "add-student-dto";
        }
        Student student = StudentMapper.studentDtoToStudent(studentDto);
        studentService.saveStudent(student);

        return "redirect:/";
    }

    @GetMapping("/students")
    public String showStudent(Model model) {
        model.addAttribute("studentList", studentService.showStudents());
        model.addAttribute("filterModel", new SimpleFilter());
        return "students";
    }

    @GetMapping("/students/search")
    public String searchStudent(@ModelAttribute("filterModel") SimpleFilter filter, Model model) {
        model.addAttribute("studentList", studentService.findStudentsByFilter(filter));
        return "students";
    }

    @GetMapping("/student/pages")
    public String studentsByPage(Model model, @PageableDefault Pageable pageable) {
        Page<Student> page = studentService.findStudentByPage(pageable);

        int currentPage = page.getNumber();

        int begin = Math.max(1, currentPage - 5);
        int end = Math.min(begin + 5, page.getNumber());

        model.addAttribute("beginIndex", begin);
        model.addAttribute("endIndex", end);
        model.addAttribute("currentPage", currentPage);
        model.addAttribute("studentsList", page);

        model.addAttribute("studentsListBySize", page.getContent());
        return "students-by-page";
    }

    @GetMapping("/student/{studentId}")
    public String findStudentById(@PathVariable("studentId") int id) {
        Student student = studentService.showStudentById(id);
        System.out.println(student);
        return "home";
    }

    @GetMapping("/student/create")
    public String createTestStudent() {
        StudentDetails details = new StudentDetails();
        details.setEmail("some.email@email.com");
        Student student = new Student();
        student.setLastName("lac");
        studentService.saveStudent(student);
        return "home";
    }
}
