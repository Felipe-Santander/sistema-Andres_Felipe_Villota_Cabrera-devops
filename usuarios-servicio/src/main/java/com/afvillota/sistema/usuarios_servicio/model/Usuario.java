package com.afvillota.sistema.usuarios_servicio.model;// Revisa tu package

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Data; // Necesita la dependencia Lombok
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Document(collection = "usuarios") // Nombre de la colección en MongoDB
@Data // Lombok: genera getters, setters, toString, equals, hashCode
@NoArgsConstructor // Lombok: genera constructor sin argumentos
@AllArgsConstructor // Lombok: genera constructor con todos los argumentos
public class Usuario {

    @Id // Marca este campo como el ID en MongoDB (automáticamente será un ObjectId si es String)
    private String id;

    private String nombre;
    private String apellido;
    private String email;
    // Más adelante podríamos añadir roles, contraseña, etc. para seguridad [source: 11]
}