package com.afvillota.sistema.matriculas_servicio.service; // Revisa tu package

import com.afvillota.sistema.matriculas_servicio.model.Matricula;
import java.util.List;
import java.util.Optional;

public interface MatriculaService {
    List<Matricula> findAll();
    Optional<Matricula> findById(String id);
    Matricula save(Matricula matricula);
    void deleteById(String id);

    // --- AÑADIR ESTA LÍNEA ---
    Optional<Matricula> crearMatricula(String usuarioId, String asignaturaId);
    // ------------------------

}