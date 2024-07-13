package com.ga7.ga7.repository;

import com.ga7.ga7.model.Aprendiz;
import org.springframework.data.jpa.repository.JpaRepository;

// Interfaz de repositorio que gestiona la entidad Aprendiz
public interface AprendizRepository extends JpaRepository<Aprendiz, Long>{
    
}
