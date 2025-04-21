package com.afvillota.sistema.usuarios_servicio.service; // Revisa tu package

import com.afvillota.sistema.usuarios_servicio.model.Usuario;
import com.afvillota.sistema.usuarios_servicio.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service; // Marca como servicio de Spring
import java.util.List;
import java.util.Optional;

@Service // Indica que es un componente de servicio gestionado por Spring
public class UsuarioServiceImpl implements UsuarioService {

    // Inyectamos el repositorio para poder usarlo
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public List<Usuario> findAll() {
        return usuarioRepository.findAll(); // Usa el método heredado de MongoRepository
    }

    @Override
    public Optional<Usuario> findById(String id) {
        return usuarioRepository.findById(id); // Usa el método heredado
    }

    @Override
    public Usuario save(Usuario usuario) {
        // Aquí podríamos añadir lógica extra antes o después de guardar
        // (validaciones, encriptar contraseña, etc.)
        return usuarioRepository.save(usuario); // Usa el método heredado
    }

    @Override
    public void deleteById(String id) {
        usuarioRepository.deleteById(id); // Usa el método heredado
    }
}