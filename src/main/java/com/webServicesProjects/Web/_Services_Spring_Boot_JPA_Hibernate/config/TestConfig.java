package com.webServicesProjects.Web._Services_Spring_Boot_JPA_Hibernate.config;

import com.webServicesProjects.Web._Services_Spring_Boot_JPA_Hibernate.entities.Category;
import com.webServicesProjects.Web._Services_Spring_Boot_JPA_Hibernate.entities.Order;
import com.webServicesProjects.Web._Services_Spring_Boot_JPA_Hibernate.entities.Product;
import com.webServicesProjects.Web._Services_Spring_Boot_JPA_Hibernate.entities.User;
import com.webServicesProjects.Web._Services_Spring_Boot_JPA_Hibernate.entities.enums.OrderStatus;
import com.webServicesProjects.Web._Services_Spring_Boot_JPA_Hibernate.repositories.CategoryRepository;
import com.webServicesProjects.Web._Services_Spring_Boot_JPA_Hibernate.repositories.OrderRepository;
import com.webServicesProjects.Web._Services_Spring_Boot_JPA_Hibernate.repositories.ProductRepository;
import com.webServicesProjects.Web._Services_Spring_Boot_JPA_Hibernate.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.Instant;
import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ProductRepository productRepository;

    @Override
    public void run(String... args) throws Exception {

        User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
        User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456");

        userRepository.saveAll(Arrays.asList(u1,u2));

        Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"),OrderStatus.PAID, u1);
        Order o2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"),OrderStatus.CANCELED, u2);
        Order o3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"),OrderStatus.DELIVERED, u1);

        orderRepository.saveAll(Arrays.asList(o1,o2,o3));

        Category cat1 = new Category(null, "Electronics");
        Category cat2 = new Category(null, "Books");
        Category cat3 = new Category(null, "Computers");

        categoryRepository.saveAll(Arrays.asList(cat1,cat2,cat3));

        Product p1 = new Product(null, "The Lord of the Rings", " A história é ambientada em um mundo fictício chamado Terra Média", 90.5, "");
        Product p2 = new Product(null, "Smart TV", "45 polegadas", 2190.0, "");
        Product p3 = new Product(null, "Macbook Pro", "MacBook", 1250.0, "");
        Product p4 = new Product(null, "PC Gamer", "32G RAM", 1200.0, "");
        Product p5 = new Product(null, "Rich dad, Poor dad", " Experiências de vida de Kiyosaki, mostrando a diferença de mentalidade financeira", 50.99, "");

        productRepository.saveAll(Arrays.asList(p1,p2,p3,p4,p5));

        p1.getCategories().add(cat2);
        p2.getCategories().add(cat1);
        p2.getCategories().add(cat3);
        p3.getCategories().add(cat3);
        p4.getCategories().add(cat3);
        p5.getCategories().add(cat2);

        productRepository.saveAll(Arrays.asList(p1,p2,p3,p4,p5));

    }

}
