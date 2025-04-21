package com.afvillota.sistema.matriculas_servicio.model; // Revisa tu package

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.time.LocalDateTime; // Para la fecha

@Document(collection = "matriculas") // Colección en MongoDB
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Matricula {

    @Id
    private String id;

    private String usuarioId; // Guardaremos el ID del usuario (vendrá de usuarios-servicio)
    private String asignaturaId; // Guardaremos el ID de la asignatura (vendrá de asignaturas-servicio)
    private LocalDateTime fechaMatricula;
    private String estado; // Ejemplo: "ACTIVA", "COMPLETADA", "CANCELADA"

    // Más adelante, podríamos querer guardar aquí una copia de la información
    // del usuario y la asignatura para evitar llamadas constantes, o solo los IDs.
    // Por ahora, solo IDs.
}