package com.afvillota.sistema.matriculas_servicio; // Revisa tu package

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients; // Importa Feign

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients // <--- ¡AÑADE ESTA LÍNEA PARA HABILITAR FEIGN!
public class MatriculasServicioApplication {

    public static void main(String[] args) {
        SpringApplication.run(MatriculasServicioApplication.class, args);
    }
}