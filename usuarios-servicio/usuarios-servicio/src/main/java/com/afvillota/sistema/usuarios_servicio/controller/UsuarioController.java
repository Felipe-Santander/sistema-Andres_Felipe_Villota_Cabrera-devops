package com.afvillota.sistema.usuarios_servicio.controller; // Revisa tu package

import com.afvillota.sistema.usuarios_servicio.model.Usuario;
import com.afvillota.sistema.usuarios_servicio.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*; // Importa todas las anotaciones web

import java.util.List;

@RestController // Indica que es un controlador REST
@RequestMapping("/api/usuarios") // Ruta base para todos los endpoints de usuarios
public class UsuarioController {

    // Inyectamos el servicio
    @Autowired
    private UsuarioService usuarioService;

    // Endpoint para obtener todos los usuarios (GET /api/usuarios)
    @GetMapping
    public ResponseEntity<List<Usuario>> getAllUsuarios() {
        List<Usuario> usuarios = usuarioService.findAll();
        return ResponseEntity.ok(usuarios); // Devuelve 200 OK con la lista
    }

    // Endpoint para obtener un usuario por ID (GET /api/usuarios/{id})
    @GetMapping("/{id}")
    public ResponseEntity<Usuario> getUsuarioById(@PathVariable String id) {
        return usuarioService.findById(id)
                .map(usuario -> ResponseEntity.ok(usuario)) // Si se encuentra, devuelve 200 OK con el usuario
                .orElse(ResponseEntity.notFound().build()); // Si no, devuelve 404 Not Found
    }

    // Endpoint para crear un nuevo usuario (POST /api/usuarios)
    @PostMapping
    public ResponseEntity<Usuario> createUsuario(@RequestBody Usuario usuario) {
        Usuario nuevoUsuario = usuarioService.save(usuario);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoUsuario); // Devuelve 201 Created con el usuario creado
    }

    /* --- Opcional: Endpoints para Actualizar y Borrar ---
       Puedes añadirlos ahora o más tarde si quieres enfocarte en Crear y Leer primero.

    // Endpoint para actualizar un usuario (PUT /api/usuarios/{id})
    @PutMapping("/{id}")
    public ResponseEntity<Usuario> updateUsuario(@PathVariable String id, @RequestBody Usuario usuarioDetails) {
        return usuarioService.findById(id)
                .map(usuario -> {
                    usuario.setNombre(usuarioDetails.getNombre());
                    usuario.setApellido(usuarioDetails.getApellido());
                    usuario.setEmail(usuarioDetails.getEmail());
                    // Actualizar otros campos si es necesario
                    Usuario updatedUsuario = usuarioService.save(usuario);
                    return ResponseEntity.ok(updatedUsuario);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    // Endpoint para borrar un usuario (DELETE /api/usuarios/{id})
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUsuario(@PathVariable String id) {
        return usuarioService.findById(id)
                .map(usuario -> {
                    usuarioService.deleteById(id);
                    return ResponseEntity.noContent().build(); // Devuelve 204 No Content
                })
                .orElse(ResponseEntity.notFound().build()); // Devuelve 404 si no existe
    }
    ---------------------------------------------------------- */
}