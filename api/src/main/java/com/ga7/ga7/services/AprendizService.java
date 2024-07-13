package com.ga7.ga7.services;

import com.ga7.ga7.model.Aprendiz;

// Interfaz que define los métodos para manipular entidades Aprendiz
public interface AprendizService {
    
    // Método para crear un nuevo aprendiz
    Aprendiz newAprendiz(Aprendiz newAprendiz);
    
    // Método para obtener todos los aprendices
    Iterable<Aprendiz> getAll();
    
    // Método para modificar un aprendiz existente
    Aprendiz modifyAprendiz(Aprendiz aprendiz);
    
    // Método para eliminar un aprendiz por su ID
    Boolean deleteAprendiz(Long iduser);
}
