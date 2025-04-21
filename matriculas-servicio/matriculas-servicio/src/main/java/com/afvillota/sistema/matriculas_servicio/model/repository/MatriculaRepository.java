package com.afvillota.sistema.matriculas_servicio.repository

import com.afvillota.sistema.matriculas_servicio.model.Matricula;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MatriculaRepository extends MongoRepository<Matricula, String> {
    // Hereda CRUD básico para Matricula con ID String
    // Podríamos añadir búsquedas específicas después, ej: findByUsuarioId(String usuarioId);
}