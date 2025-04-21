package com.afvillota.sistema.asignaturas_servicio.repository; // Revisa tu package

import com.afvillota.sistema.asignaturas_servicio.model.Asignatura;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AsignaturaRepository extends MongoRepository<Asignatura, String> {
    // Hereda CRUD básico para Asignatura con ID String
}