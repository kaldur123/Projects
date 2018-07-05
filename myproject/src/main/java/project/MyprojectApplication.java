package project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import project.entity.Dino;
import project.entity.Enums.UserRole;
import project.entity.Writer;
import project.repository.DinoRepository;
import project.repository.WriterRepository;

@SpringBootApplication
public class MyprojectApplication extends SpringBootServletInitializer implements CommandLineRunner {

    @Autowired private WriterRepository writerRepository;

    @Autowired private DinoRepository dinoRepository;

    @Autowired private PasswordEncoder passwordEncoder;

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(MyprojectApplication.class);
    }

    @Override
    public void run(String... args) throws Exception {
        if (writerRepository.count() == 0) {
            Writer user = Writer.builder().fullName("John Smith").age(27).email("john@gmail.com").password(passwordEncoder.encode("12345")).country("Ukraine").role(UserRole.ROLE_USER).build();
            user.setImageUrl("http://placehold.it/140x100&text=" + user.getFullName());
            writerRepository.save(user);
            Writer admin = Writer.builder().fullName("Bruce Wayne").age(35).email("bruce@gmail.com").password(passwordEncoder.encode("54321")).country("USA").role(UserRole.ROLE_ADMIN).build();
            admin.setImageUrl("http://placehold.it/140x100&text=" + admin.getFullName());
            writerRepository.save(admin);
        }
        if (dinoRepository.count() == 0) {
            Dino dino = Dino.builder().name("Tyrex").kind("Theropod").build();
            dinoRepository.save(dino);
        }
    }



    public static void main(String[] args) {
        SpringApplication.run(MyprojectApplication.class, args);
    }
}
