package com.poc.flutter.server.flutter_poc_api.controller;

import com.poc.flutter.server.flutter_poc_api.model.Paciente;
import com.poc.flutter.server.flutter_poc_api.repository.PacienteRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PacienteController {

    private PacienteRepository repository;

    public PacienteController(PacienteRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/paciente")
    List<Paciente> all() {
        return repository.findAll();
    }

    @PostMapping("/paciente")
    Paciente save(@RequestBody Paciente paciente) {
        return repository.save(paciente);
    }

    @PutMapping("/paciente/{id}")
    Paciente save(@RequestBody Paciente paciente, @PathVariable("id") Long id) {
        return repository.findById(id)
                .map(p -> {
                    p.setName(paciente.getName());
                    p.setApellido(paciente.getApellido());
                    p.setDni(paciente.getDni());
                    p.setFechaNacimiento(paciente.getFechaNacimiento());
                    p.setDomicilio(paciente.getDomicilio());
                    p.setAltura(paciente.getAltura());
                    p.setPeso(paciente.getPeso());
                    p.setEnfermedadesAntecedentesFamiliares(paciente.getEnfermedadesAntecedentesFamiliares());
                    p.setEnfermedadesPreexistentes(paciente.getEnfermedadesPreexistentes());
                    return repository.save(p);
                })
                .orElseGet(() -> {
                    paciente.setId(id);
                    return repository.save(paciente);
                });
    }

    @DeleteMapping("/paciente/{id}")
    void delete(@PathVariable("id") Long id) {
        repository.deleteById(id);
    }
}
