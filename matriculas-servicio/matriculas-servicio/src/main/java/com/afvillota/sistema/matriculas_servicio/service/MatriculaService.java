package com.afvillota.sistema.matriculas_servicio.service; // Revisa tu package

import com.afvillota.sistema.matriculas_servicio.model.Matricula;
import java.util.List;
import java.util.Optional;

public interface MatriculaService {
    List<Matricula> findAll();
    Optional<Matricula> findById(String id);
    Matricula save(Matricula matricula); // Por ahora, solo guarda
    // Más adelante tendremos un método como "crearMatricula(usuarioId, asignaturaId)" que use Feign
    void deleteById(String id);
}