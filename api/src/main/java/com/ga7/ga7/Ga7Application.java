package com.ga7.ga7;

// Importaciones necesarias para la aplicación Spring Boot
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// Anotación que marca la clase como una aplicación Spring Boot
@SpringBootApplication
public class Ga7Application {

    // Método principal que arranca la aplicación
    public static void main(String[] args) {
        // Método estático de SpringApplication para arrancar la aplicación
        SpringApplication.run(Ga7Application.class, args);
    }

}
