package com.example.cities;

import com.example.cities.repository.CityRepository;
import feign.Feign;
import feign.jackson.JacksonDecoder;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.web.config.EnableSpringDataWebSupport;

@Configuration
@ComponentScan
@EnableAutoConfiguration
@EnableSpringDataWebSupport
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
