package com.afvillota.sistema.asignaturas_servicio.service; // Revisa tu package

import com.afvillota.sistema.asignaturas_servicio.model.Asignatura;
import com.afvillota.sistema.asignaturas_servicio.repository.AsignaturaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class AsignaturaServiceImpl implements AsignaturaService {

    @Autowired
    private AsignaturaRepository asignaturaRepository;

    @Override
    public List<Asignatura> findAll() {
        return asignaturaRepository.findAll();
    }

    @Override
    public Optional<Asignatura> findById(String id) {
        return asignaturaRepository.findById(id);
    }

    @Override
    public Asignatura save(Asignatura asignatura) {
        return asignaturaRepository.save(asignatura);
    }

    @Override
    public void deleteById(String id) {
        asignaturaRepository.deleteById(id);
    }
}