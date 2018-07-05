package springboot.springbootapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import springboot.springbootapp.entity.Image;
import springboot.springbootapp.entity.Student;
import springboot.springbootapp.entity.User;
import springboot.springbootapp.repository.ImageRepository;
import springboot.springbootapp.repository.StudentRepository;
import springboot.springbootapp.repository.UserRepository;
import springboot.springbootapp.service.utils.CustomFileUtils;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@SpringBootApplication
public class SpringBootAppApplication extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(SpringBootAppApplication.class);
    }

    public static void main(String[] args) throws Exception{

        ConfigurableApplicationContext ctx = SpringApplication.run(SpringBootAppApplication.class, args);
//        addStudent(ctx);
        addUser(ctx);

    }

    private static void addStudent(ConfigurableApplicationContext ctx) {
        StudentRepository studentRepository = ctx.getBean(StudentRepository.class);
        Long students = studentRepository.count();

        if (students == 0) {
            for (int i = 0; i < 300; i++) {
                Student student = new Student();
                student.setFirstName("Student First Name #" + i);
                student.setLastName("Student Last Name #" + i);
                student.setAge(i);
                student.setPassword("Student Password #" + i);
                studentRepository.save(student);
            }
        }
    }

    private static void addUser( ConfigurableApplicationContext ctx) throws Exception {
        UserRepository userRepository = ctx.getBean(UserRepository.class);
        ImageRepository imageRepository = ctx.getBean(ImageRepository.class);
        Long users = userRepository.count();
        BufferedReader br1 = new BufferedReader(new FileReader("d:/firstName.txt"));
        BufferedReader br2 = new BufferedReader(new FileReader("d:/lastName.txt"));
        String firstName;
        String lastName;
        List<String> firstNames = new ArrayList<>();
        List<String> lastNames = new ArrayList<>();
        while ((firstName = br1.readLine()) != null) {
            firstNames.add(firstName);
        }

        while ((lastName = br2.readLine()) != null) {
            lastNames.add(lastName);
        }
        Random rd = new Random();

        if (users == 0) {
            for (int i = 0; i < 2000; i++) {
                User user = new User();
                Image image = new Image();
                user.setFirstName(firstNames.get(rd.nextInt(firstNames.size())));
                user.setLastName(lastNames.get(rd.nextInt(lastNames.size())));
                user.setEmail(user.getFirstName() + user.getLastName() + "@gmail.com");
                user.setLogin(user.getFirstName().toLowerCase());
                user.setSalary(rd.nextInt(10000) + 1000);
                int n = i + 1;
                user.setPass("password#" + n);
                CustomFileUtils.createFolder("user_"+ n);
                image.setImageName("default");
                userRepository.save(user);
                image.setUser(user);

                imageRepository.save(image);

            }
        }
    }
}
