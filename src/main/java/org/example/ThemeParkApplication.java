package org.example;

import org.example.entity.ThemeParkRide;
import org.example.repository.ThemeParkRideRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
@SpringBootApplication
public class ThemeParkApplication {
    public static void main(String[] args) {
        SpringApplication.run(ThemeParkApplication.class);
    }
    @Bean
    public CommandLineRunner sampleDate(ThemeParkRideRepository repository){
        return (args -> {
            repository.save(new ThemeParkRide("RollerCoaster", "Train ride that speeds you along",
                   4,5 ));
            repository.save(new ThemeParkRide("Log flume", "Boat ride with plenty of splashes",
                    6,7));
            repository.save(new ThemeParkRide("Teacups", "Spinning ride in a giant tea-cup",
                    7,9));
        });
    }
}
