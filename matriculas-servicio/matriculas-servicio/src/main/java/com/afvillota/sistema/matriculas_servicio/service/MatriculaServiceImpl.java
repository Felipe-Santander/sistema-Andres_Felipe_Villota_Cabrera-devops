package com.afvillota.sistema.matriculas_servicio.service; // Revisa tu package

import com.afvillota.sistema.matriculas_servicio.client.AsignaturaFeignClient; // Importa el cliente Feign
import com.afvillota.sistema.matriculas_servicio.client.UsuarioFeignClient;    // Importa el cliente Feign
import com.afvillota.sistema.matriculas_servicio.model.AsignaturaDTO; // Importa el DTO
import com.afvillota.sistema.matriculas_servicio.model.Matricula;
import com.afvillota.sistema.matriculas_servicio.model.UsuarioDTO;    // Importa el DTO
import com.afvillota.sistema.matriculas_servicio.repository.MatriculaRepository;

import feign.FeignException; // Importa la excepción de Feign
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional; // Útil para operaciones compuestas

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class MatriculaServiceImpl implements MatriculaService {

    @Autowired
    private MatriculaRepository matriculaRepository;

    // Inyectamos los clientes Feign
    @Autowired
    private UsuarioFeignClient usuarioFeignClient;

    @Autowired
    private AsignaturaFeignClient asignaturaFeignClient;


    @Override
    public List<Matricula> findAll() {
        return matriculaRepository.findAll();
    }

    @Override
    public Optional<Matricula> findById(String id) {
        return matriculaRepository.findById(id);
    }

    // Este método save sigue siendo básico, lo usaremos internamente
    @Override
    public Matricula save(Matricula matricula) {
        return matriculaRepository.save(matricula);
    }

    @Override
    public void deleteById(String id) {
        matriculaRepository.deleteById(id);
    }

    // --- NUEVO MÉTODO PARA CREAR MATRÍCULA USANDO FEIGN ---
    // Lo marcamos como @Transactional por si en el futuro hay más operaciones de escritura
    @Transactional
    public Optional<Matricula> crearMatricula(String usuarioId, String asignaturaId) {
        UsuarioDTO usuarioDTO = null;
        AsignaturaDTO asignaturaDTO = null;

        // 1. Verificar existencia del usuario llamando a usuarios-servicio
        try {
            System.out.println("Llamando a usuarios-servicio para ID: " + usuarioId);
            usuarioDTO = usuarioFeignClient.findById(usuarioId);
            System.out.println("Usuario encontrado: " + usuarioDTO.getNombre());
        } catch (FeignException.NotFound e) {
            System.err.println("Error al llamar a usuarios-servicio (Usuario no encontrado): ID " + usuarioId);
            return Optional.empty(); // Usuario no encontrado
        } catch (Exception e) {
            // Captura otras posibles excepciones de Feign (ej. servicio caído)
            System.err.println("Error general al llamar a usuarios-servicio: " + e.getMessage());
            // Aquí podríamos lanzar una excepción más específica o manejarlo diferente
            return Optional.empty();
        }

        // 2. Verificar existencia de la asignatura llamando a asignaturas-servicio
        try {
            System.out.println("Llamando a asignaturas-servicio para ID: " + asignaturaId);
            asignaturaDTO = asignaturaFeignClient.findById(asignaturaId);
            System.out.println("Asignatura encontrada: " + asignaturaDTO.getNombre());
        } catch (FeignException.NotFound e) {
            System.err.println("Error al llamar a asignaturas-servicio (Asignatura no encontrada): ID " + asignaturaId);
            return Optional.empty(); // Asignatura no encontrada
        } catch (Exception e) {
            System.err.println("Error general al llamar a asignaturas-servicio: " + e.getMessage());
            return Optional.empty();
        }

        // 3. Si ambos existen, crear y guardar la matrícula
        if (usuarioDTO != null && asignaturaDTO != null) {
            Matricula nuevaMatricula = new Matricula();
            nuevaMatricula.setUsuarioId(usuarioId); // Guardamos solo el ID
            nuevaMatricula.setAsignaturaId(asignaturaId); // Guardamos solo el ID
            nuevaMatricula.setFechaMatricula(LocalDateTime.now());
            nuevaMatricula.setEstado("ACTIVA"); // Establecemos estado inicial

            // 4. Guardar en la BD local de matrículas
            Matricula matriculaGuardada = matriculaRepository.save(nuevaMatricula);
            System.out.println("Matrícula creada exitosamente con ID: " + matriculaGuardada.getId());
            return Optional.of(matriculaGuardada);
        } else {
            // Esto no debería pasar si las llamadas Feign fueron exitosas, pero por si acaso
            System.err.println("No se pudo obtener la información del usuario o asignatura, aunque no hubo excepción.");
            return Optional.empty();
        }
    }

    // Modificamos la interfaz MatriculaService para incluir el nuevo método
    // (Puedes hacer esto en MatriculaService.java)
    // Optional<Matricula> crearMatricula(String usuarioId, String asignaturaId);

}