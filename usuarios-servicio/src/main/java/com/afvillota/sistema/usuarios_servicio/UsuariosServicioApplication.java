package com.afvillota.sistema.usuarios_servicio; // Revisa que tu package sea correcto

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient; // Importa la clase

@SpringBootApplication
@EnableDiscoveryClient // <--- AÑADE ESTA LÍNEA (o asegúrate que esté)
public class UsuariosServicioApplication {

    public static void main(String[] args) {
        SpringApplication.run(UsuariosServicioApplication.class, args);
    }

}