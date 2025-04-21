package com.afvillota.sistema.asignaturas_servicio.model; // Revisa tu package

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Document(collection = "asignaturas") // Colección en MongoDB
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Asignatura {

    @Id
    private String id;

    private String nombre;
    private String descripcion;
    private int creditos;
}