package com.afvillota.sistema.asignaturas_servicio.controller;

import com.afvillota.sistema.asignaturas_servicio.model.Asignatura;
import com.afvillota.sistema.asignaturas_servicio.service.AsignaturaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus; // Asegúrate de importar HttpStatus
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional; // Asegúrate de importar Optional

@RestController
@RequestMapping("/api/asignaturas") // Ruta base para asignaturas
public class AsignaturaController {

    @Autowired
    private AsignaturaService asignaturaService;

    // GET /api/asignaturas - Obtener todas
    @GetMapping
    public ResponseEntity<List<Asignatura>> getAllAsignaturas() {
        return ResponseEntity.ok(asignaturaService.findAll());
    }

    // GET /api/asignaturas/{id} - Obtener por ID
    @GetMapping("/{id}")
    public ResponseEntity<Asignatura> getAsignaturaById(@PathVariable String id) {
        return asignaturaService.findById(id)
                .map(ResponseEntity::ok) // Forma corta de .map(asignatura -> ResponseEntity.ok(asignatura))
                .orElse(ResponseEntity.notFound().build());
    }

    // POST /api/asignaturas - Crear nueva
    @PostMapping
    public ResponseEntity<Asignatura> createAsignatura(@RequestBody Asignatura asignatura) {
        Asignatura nuevaAsignatura = asignaturaService.save(asignatura);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevaAsignatura);
    }

    // PUT /api/asignaturas/{id} - Actualizar (Opcional)
    @PutMapping("/{id}")
    public ResponseEntity<Asignatura> updateAsignatura(@PathVariable String id, @RequestBody Asignatura asignaturaDetails) {
        // Verifica si la asignatura existe antes de intentar obtenerla
        Optional<Asignatura> currentAsignaturaOptional = asignaturaService.findById(id);
        if (!currentAsignaturaOptional.isPresent()) {
             return ResponseEntity.notFound().build();
        }

        // Como sabemos que existe, obtenemos la asignatura actual
        Asignatura currentAsignatura = currentAsignaturaOptional.get();

        // Actualizamos los campos con los detalles recibidos
        // ¡Asegúrate que Asignatura tiene los setters (Lombok @Data debería crearlos)!
        currentAsignatura.setNombre(asignaturaDetails.getNombre());
        currentAsignatura.setDescripcion(asignaturaDetails.getDescripcion());
        currentAsignatura.setCreditos(asignaturaDetails.getCreditos());

        // Guardamos la asignatura actualizada
        Asignatura updatedAsignatura = asignaturaService.save(currentAsignatura);
        return ResponseEntity.ok(updatedAsignatura);

        // Forma funcional original (requiere que Lombok funcione bien en el editor para no dar error getNombre, etc.)
        /*
        return asignaturaService.findById(id)
                .map(asignatura -> {
                    asignatura.setNombre(asignaturaDetails.getNombre());
                    asignatura.setDescripcion(asignaturaDetails.getDescripcion());
                    asignatura.setCreditos(asignaturaDetails.getCreditos());
                    // Actualizar otros campos...
                    Asignatura updatedAsignatura = asignaturaService.save(asignatura);
                    return ResponseEntity.ok(updatedAsignatura);
                })
                .orElse(ResponseEntity.notFound().build());
        */
    }

    // DELETE /api/asignaturas/{id} - Borrar (Corregido)
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAsignatura(@PathVariable String id) {
        // Primero busca si la asignatura existe
        Optional<Asignatura> asignaturaOptional = asignaturaService.findById(id);

        if (asignaturaOptional.isPresent()) {
            // Si existe, bórrala
            asignaturaService.deleteById(id);
            // Devuelve 204 No Content (que es ResponseEntity<Void>)
            return ResponseEntity.noContent().build();
        } else {
            // Si no existe, devuelve 404 Not Found (compatible con <Void>)
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}