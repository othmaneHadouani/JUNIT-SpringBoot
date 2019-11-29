package org.sid.demo;

import org.sid.demo.dao.PersonneRepeository;
import org.sid.demo.entities.Personne;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoApplication  {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }




    @Bean
    CommandLineRunner start(PersonneRepeository personneRepeository){
        return args -> {

            personneRepeository.save(new Personne("othmane","hadouani"));
            personneRepeository.save(new Personne("souad","bassit"));

        };
    }
}
