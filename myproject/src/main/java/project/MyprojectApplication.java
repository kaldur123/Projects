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

import java.util.Random;

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
            for (int i = 0; i < 10; i++) {
                Writer writer = Writer.builder().fullName("Name#" + i).age(new Random().nextInt(50) + 18).email("name#" + i + "@gmail.com").password(passwordEncoder.encode("name#" + i)).country("England").role(UserRole.ROLE_USER).build();
                writer.setImageUrl("http://placehold.it/140x100&text=" + writer.getFullName());
                writerRepository.save(writer);
            }
            for (int i = 10; i < 20; i++) {
                Writer writer = Writer.builder().fullName("Name#" + i).age(new Random().nextInt(50) + 18).email("name#" + i + "@gmail.com").password(passwordEncoder.encode("name#" + i)).country("Poland").role(UserRole.ROLE_USER).build();
                writer.setImageUrl("http://placehold.it/140x100&text=" + writer.getFullName());
                writerRepository.save(writer);
            }
            for (int i = 20; i < 30; i++) {
                Writer writer = Writer.builder().fullName("Name#" + i).age(new Random().nextInt(50) + 18).email("name#" + i + "@gmail.com").password(passwordEncoder.encode("name#" + i)).country("USA").role(UserRole.ROLE_USER).build();
                writer.setImageUrl("http://placehold.it/140x100&text=" + writer.getFullName());
                writerRepository.save(writer);
            }
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
