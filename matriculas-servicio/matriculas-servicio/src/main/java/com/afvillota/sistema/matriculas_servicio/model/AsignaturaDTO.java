package com.afvillota.sistema.matriculas_servicio.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AsignaturaDTO {
    // Solo los campos que esperamos recibir de asignaturas-servicio
    private String id;
    private String nombre;
    private int creditos;
}