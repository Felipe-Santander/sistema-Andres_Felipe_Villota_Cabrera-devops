package com.afvillota.sistema.asignaturas_servicio.service; // Revisa tu package

import com.afvillota.sistema.asignaturas_servicio.model.Asignatura;
import java.util.List;
import java.util.Optional;

public interface AsignaturaService {
    List<Asignatura> findAll();
    Optional<Asignatura> findById(String id);
    Asignatura save(Asignatura asignatura);
    void deleteById(String id);
}