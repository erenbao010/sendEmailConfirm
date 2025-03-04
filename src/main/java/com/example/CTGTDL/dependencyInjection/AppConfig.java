package com.example.CTGTDL.dependencyInjection;


import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.example.DI")
public class AppConfig {
   @Bean
   public Engine engine() {
       return new Engine ("v8",5);
   }
    @Bean
    public Transmission transmission() {
        return new Transmission ("go around", true);
    }

}
