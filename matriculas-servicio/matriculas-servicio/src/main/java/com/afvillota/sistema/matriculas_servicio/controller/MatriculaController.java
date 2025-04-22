package com.afvillota.sistema.matriculas_servicio.controller; // Revisa tu package

import com.afvillota.sistema.matriculas_servicio.model.Matricula;
import com.afvillota.sistema.matriculas_servicio.model.MatriculaRequestDTO;
import com.afvillota.sistema.matriculas_servicio.service.MatriculaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional; // <--- IMPORT AÑADIDO

@RestController
@RequestMapping("/api/matriculas")
public class MatriculaController {

    @Autowired
    private MatriculaService matriculaService;

    @GetMapping("/status")
    public ResponseEntity<String> getStatus() {
        return ResponseEntity.ok("Servicio de Matrículas Funcionando!");
    }

    @PostMapping
    public ResponseEntity<?> registrarMatricula(@RequestBody MatriculaRequestDTO request) {
        try {
            // Llama al método del servicio que usa Feign
            // Asumiendo que Lombok funciona para generar getUsuarioId/getAsignaturaId en request
            Optional<Matricula> matriculaCreada = matriculaService.crearMatricula(request.getUsuarioId(), request.getAsignaturaId());

            if (matriculaCreada.isPresent()) {
                return ResponseEntity.status(HttpStatus.CREATED).body(matriculaCreada.get());
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND)
                       .body("Error: Usuario o Asignatura no encontrado con los IDs proporcionados.");
            }
        } catch (Exception e) {
            System.err.println("Error inesperado al registrar matrícula: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                   .body("Error interno al procesar la matrícula.");
        }
    }
}