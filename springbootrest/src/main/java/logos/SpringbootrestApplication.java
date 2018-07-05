package logos;

import logos.entity.Product;
import logos.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

import java.math.BigDecimal;

@SpringBootApplication
public class SpringbootrestApplication extends SpringBootServletInitializer implements CommandLineRunner {

    @Autowired private ProductRepository productRepository;

    public static void main(String[] args) {
        SpringApplication.run(SpringbootrestApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        if (productRepository.count() == 0) {
            Product product1 = Product.builder().name("Samsung S6")
                                                .description("China phone")
                                                .price(new BigDecimal(599.99))
                                                .imageUrl("http://-url")
                                                .rating(3).build();
            Product product2 = Product.builder().name("Xiaomi Mi X")
                                                .description("China phone")
                                                .price(new BigDecimal(449.99))
                                                .imageUrl("http://-url")
                                                .rating(5).build();
            productRepository.save(product1);
            productRepository.save(product2);
        }
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(SpringbootrestApplication.class);
    }
}
