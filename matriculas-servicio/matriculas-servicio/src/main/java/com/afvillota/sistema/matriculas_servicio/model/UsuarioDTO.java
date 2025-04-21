package com.afvillota.sistema.matriculas_servicio.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data // Lombok para getters/setters
@NoArgsConstructor // Lombok para constructor vacío (necesario para deserialización JSON)
public class UsuarioDTO {
    // Solo los campos que esperamos recibir de usuarios-servicio
    private String id;
    private String nombre;
    private String apellido;
    private String email;
}