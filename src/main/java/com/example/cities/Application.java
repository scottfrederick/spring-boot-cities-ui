package com.example.cities;

import com.example.cities.model.City;
import com.example.cities.repository.CityRepository;
import com.example.cities.repository.PagedResourcesDecoder;
import feign.Feign;
import feign.jackson.JacksonDecoder;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
@EnableAutoConfiguration
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public CityRepository repository() {
        return Feign.builder()
                .decoder(new JacksonDecoder())
                .target(CityRepository.class, "http://cities.apps.scottfrederick.io");
    }
}
