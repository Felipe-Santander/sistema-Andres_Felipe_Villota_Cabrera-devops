package com.afvillota.sistema.usuarios_servicio.service; // Revisa tu package

import com.afvillota.sistema.usuarios_servicio.model.Usuario;
import java.util.List;
import java.util.Optional;

public interface UsuarioService {
    List<Usuario> findAll(); // Obtener todos los usuarios
    Optional<Usuario> findById(String id); // Buscar usuario por ID
    Usuario save(Usuario usuario); // Guardar un usuario (nuevo o existente)
    void deleteById(String id); // Borrar un usuario por ID
    // Podríamos añadir más métodos después (buscar por email, actualizar parcialmente, etc.)
}