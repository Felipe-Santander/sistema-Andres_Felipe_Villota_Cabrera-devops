package com.afvillota.sistema.usuarios_servicio.repository; // Revisa tu package

import com.afvillota.sistema.usuarios_servicio.model.Usuario;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository // Indica que es un componente de repositorio gestionado por Spring
public interface UsuarioRepository extends MongoRepository<Usuario, String> {
    // MongoRepository<TipoDeEntidad, TipoDelId>

    // Spring Data MongoDB generará automáticamente los métodos CRUD básicos:
    // save(), findById(), findAll(), deleteById(), etc.

    // Podemos añadir métodos de búsqueda personalizados si los necesitamos más adelante.
    // Ejemplo: Optional<Usuario> findByEmail(String email);
}