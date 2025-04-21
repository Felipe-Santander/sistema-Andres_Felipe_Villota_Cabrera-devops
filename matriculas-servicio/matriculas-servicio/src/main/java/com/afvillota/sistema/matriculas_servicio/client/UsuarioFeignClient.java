package com.afvillota.sistema.matriculas_servicio.client;

// Importa el *MODELO* del otro servicio (Necesitaremos una forma de compartirlo o duplicarlo)
// Por ahora, vamos a crear una clase simple aquí mismo para representar lo que esperamos recibir.
// ESTO ES UNA SIMPLIFICACIÓN TEMPORAL. Lo ideal sería tener un módulo común.
import com.afvillota.sistema.matriculas_servicio.model.UsuarioDTO; // Crearemos este DTO

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

// name="usuarios-servicio" debe coincidir EXACTAMENTE con el spring.application.name
// del servicio de usuarios registrado en Eureka.
@FeignClient(name = "usuarios-servicio", path = "/api/usuarios") // path opcional si es la base
public interface UsuarioFeignClient {

    // La firma debe coincidir con el endpoint del controlador en usuarios-servicio
    @GetMapping("/{id}")
    UsuarioDTO findById(@PathVariable String id); // Esperamos recibir un UsuarioDTO
}