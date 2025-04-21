package com.afvillota.sistema.matriculas_servicio.controller; // Revisa tu package

// Todavía no necesitamos importar Matricula o MatriculaService para el status
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/matriculas") // Ruta base
public class MatriculaController {

    // Inyectaremos el servicio después cuando creemos endpoints reales
    // @Autowired
    // private MatriculaService matriculaService;

    @GetMapping("/status")
    public ResponseEntity<String> getStatus() {
        return ResponseEntity.ok("Servicio de Matrículas Funcionando!");
    }

    // Aquí irán los endpoints POST, GET, etc. que usen el servicio y Feign
}