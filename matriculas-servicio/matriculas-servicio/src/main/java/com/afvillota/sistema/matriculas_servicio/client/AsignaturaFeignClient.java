package com.afvillota.sistema.matriculas_servicio.client;

// Simplificación temporal, crearemos este DTO
import com.afvillota.sistema.matriculas_servicio.model.AsignaturaDTO;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

// name="asignaturas-servicio" debe coincidir con el spring.application.name en Eureka.
@FeignClient(name = "asignaturas-servicio", path = "/api/asignaturas")
public interface AsignaturaFeignClient {

    // La firma debe coincidir con el endpoint en asignaturas-servicio
    @GetMapping("/{id}")
    AsignaturaDTO findById(@PathVariable String id); // Esperamos recibir AsignaturaDTO
}