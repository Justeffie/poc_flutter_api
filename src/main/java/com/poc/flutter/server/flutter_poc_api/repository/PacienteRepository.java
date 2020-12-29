package com.poc.flutter.server.flutter_poc_api.repository;

import com.poc.flutter.server.flutter_poc_api.model.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PacienteRepository extends JpaRepository<Paciente, Long> {
}
