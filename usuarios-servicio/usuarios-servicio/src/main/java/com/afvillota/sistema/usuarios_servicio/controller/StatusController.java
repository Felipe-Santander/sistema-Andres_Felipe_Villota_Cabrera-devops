package com.afvillota.sistema.usuarios_servicio.controller; // Revisa tu package

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/usuarios")
public class StatusController {

    @GetMapping("/status")
    public String checkStatus() {
        return "Servicio de Usuarios Funcionando Correctamente!";
    }
}