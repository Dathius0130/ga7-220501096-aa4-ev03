package com.ga7.ga7.model;

// Importaciones necesarias para la entidad
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import lombok.Data;

// Anotación que indica que esta clase es una entidad JPA
@Entity

// Anotación de Lombok para generar automáticamente getters, setters, equals, hashCode y toString
@Data
public class Aprendiz {
    
    // Identificador único del aprendiz
    @Id
    @Column
    private Long iduser;
    
    // Nombre del aprendiz
    @Column
    private String nomuser;
    
    // Apellido del aprendiz
    @Column
    private String apellido;
    
    // Correo electrónico del aprendiz
    @Column
    private String email;
    
}
