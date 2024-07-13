package com.ga7.ga7.services;

import com.ga7.ga7.model.Aprendiz;
import com.ga7.ga7.repository.AprendizRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// Anotación que marca esta clase como un servicio de Spring
@Service
public class AprendizServiceImpl implements AprendizService {
    
    // Inyección de dependencia del repositorio AprendizRepository
    @Autowired
    private AprendizRepository aprendizRepository;

    // Método para crear un nuevo aprendiz
    @Override
    public Aprendiz newAprendiz(Aprendiz newAprendiz) {
        return aprendizRepository.save(newAprendiz);
    }

    // Método para obtener todos los aprendices
    @Override
    public Iterable<Aprendiz> getAll() {
        return this.aprendizRepository.findAll();
    }

    // Método para modificar un aprendiz existente
    @Override
    public Aprendiz modifyAprendiz(Aprendiz aprendiz) {
        // Buscar el aprendiz por su ID
        Optional<Aprendiz> aprendizEncontrado = this.aprendizRepository.findById(aprendiz.getIduser());
        
        // Verificar si se encontró el aprendiz
        if (aprendizEncontrado.isPresent()) {
            // Modificar los campos del aprendiz encontrado
            aprendizEncontrado.get().setNomuser(aprendiz.getNomuser());
            aprendizEncontrado.get().setApellido(aprendiz.getApellido());
            aprendizEncontrado.get().setEmail(aprendiz.getEmail());
            
            // Guardar los cambios y devolver el aprendiz modificado
            return this.newAprendiz(aprendizEncontrado.get());
        }
        
        // Devolver null si no se encontró el aprendiz
        return null;
    }

    // Método para eliminar un aprendiz por su ID
    @Override
    public Boolean deleteAprendiz(Long iduser) {
        // Eliminar el aprendiz por su ID
        this.aprendizRepository.deleteById(iduser);
        return true;
    }
}
