package com.afvillota.sistema.matriculas_servicio.service; // Revisa tu package

import com.afvillota.sistema.matriculas_servicio.model.Matricula;
import com.afvillota.sistema.matriculas_servicio.repository.MatriculaRepository;
// Faltan imports para Feign Clients (los añadiremos después)
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime; // Para la fecha
import java.util.List;
import java.util.Optional;

@Service
public class MatriculaServiceImpl implements MatriculaService {

    @Autowired
    private MatriculaRepository matriculaRepository;

    // Aquí inyectaremos los Feign Clients después
    // @Autowired private UsuarioFeignClient usuarioFeignClient;
    // @Autowired private AsignaturaFeignClient asignaturaFeignClient;


    @Override
    public List<Matricula> findAll() {
        return matriculaRepository.findAll();
    }

    @Override
    public Optional<Matricula> findById(String id) {
        return matriculaRepository.findById(id);
    }

    // Este método es MUY básico por ahora, solo guarda lo que recibe.
    // La versión final necesitará recibir IDs, validar con Feign y luego guardar.
    @Override
    public Matricula save(Matricula matricula) {
        // En la versión básica, podríamos asignar fecha y estado por defecto aquí si no vienen

        // Estas líneas dependen de que Lombok (@Data en Matricula.java) genere los métodos
        if (matricula.getFechaMatricula() == null) { // <-- Editor necesita ver getFechaMatricula() de Lombok
             matricula.setFechaMatricula(LocalDateTime.now()); // <-- Editor necesita ver setFechaMatricula() de Lombok
        }
         if (matricula.getEstado() == null) { // <-- Editor necesita ver getEstado() de Lombok
             matricula.setEstado("PENDIENTE_VALIDACION"); // <-- Editor necesita ver setEstado() de Lombok
        }
        return matriculaRepository.save(matricula);
    }

    @Override
    public void deleteById(String id) {
        matriculaRepository.deleteById(id);
    }

    // Método futuro que usará Feign (solo ejemplo, no implementar aún)
    /*
    public Matricula crearMatriculaCompleta(String usuarioId, String asignaturaId) {
        // 1. Validar que usuarioId existe llamando a usuarios-servicio via Feign
        // 2. Validar que asignaturaId existe llamando a asignaturas-servicio via Feign
        // 3. Si ambos existen, crear el objeto Matricula
        Matricula nueva = new Matricula();
        nueva.setUsuarioId(usuarioId);
        nueva.setAsignaturaId(asignaturaId);
        nueva.setFechaMatricula(LocalDateTime.now());
        nueva.setEstado("ACTIVA");
        // 4. Guardar en la BD de matrículas
        return matriculaRepository.save(nueva);
    }
    */
}