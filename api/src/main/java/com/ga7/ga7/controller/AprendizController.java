package com.ga7.ga7.controller;

import com.ga7.ga7.model.Aprendiz;
import com.ga7.ga7.services.AprendizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/aprendiz")
public class AprendizController {

    // Inyección de dependencia del servicio AprendizService
    @Autowired
    private AprendizService aprendizService;

    // Método para crear un nuevo aprendiz mediante una solicitud POST
    @PostMapping("/nuevo")
    public Aprendiz newAprendiz(@RequestBody Aprendiz newAprendiz) {
        return this.aprendizService.newAprendiz(newAprendiz);
    }

    // Método para obtener todos los aprendices mediante una solicitud GET
    @GetMapping("/mostrar")
    public Iterable<Aprendiz> getAll() {
        return aprendizService.getAll();
    }

    // Método para modificar un aprendiz existente mediante una solicitud POST
    @PostMapping("/modificar")
    public Aprendiz updateAprendiz(@RequestBody Aprendiz aprendiz) {
        return this.aprendizService.modifyAprendiz(aprendiz);
    }

    // Método para eliminar un aprendiz mediante una solicitud POST con un parámetro de ruta (ID)
    @PostMapping(value = "/{id}")
    public Boolean deleteAprendiz(@PathVariable(value = "id") Long id) {
        return this.aprendizService.deleteAprendiz(id);
    }
}
