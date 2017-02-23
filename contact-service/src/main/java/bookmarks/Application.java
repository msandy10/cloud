package bookmarks;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableEurekaClient
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    CommandLineRunner init(ContactRepository contactRepository) {
        return args -> {
            System.out.println("----------------Populationg Contact Table-----------------------");
            Arrays.asList("mstine", "jlong").forEach(n ->
            contactRepository.save(new Contact(n,n + "@gmail.com.com",n+" FirstName" ,n+" LastName")));
            System.out.println("---------------------------------------");
            			contactRepository.findAll().stream().forEach(System.out::println);
            System.out.println("---------------------------------------");
        };
    }
}

