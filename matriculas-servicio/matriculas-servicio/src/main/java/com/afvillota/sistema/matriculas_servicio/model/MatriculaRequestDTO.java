package com.afvillota.sistema.matriculas_servicio.model;

import lombok.Data;
import lombok.NoArgsConstructor;

// DTO simple para recibir los IDs en la petición POST
@Data
@NoArgsConstructor
public class MatriculaRequestDTO {
    private String usuarioId;
    private String asignaturaId;
}