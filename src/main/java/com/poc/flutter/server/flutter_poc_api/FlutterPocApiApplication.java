package com.poc.flutter.server.flutter_poc_api;

import com.poc.flutter.server.flutter_poc_api.model.Enfermedad;
import com.poc.flutter.server.flutter_poc_api.model.Paciente;
import com.poc.flutter.server.flutter_poc_api.repository.PacienteRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootApplication
public class FlutterPocApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(FlutterPocApiApplication.class, args);
    }

}

@Configuration
class LoadDatabase {

    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(PacienteRepository repository) {

        return args -> {
            Paciente newPaciente = new Paciente(1L, "Nicolas", "Cailotto", 35962314, Date.from(LocalDate.of(1991, Calendar.APRIL, 11).atStartOfDay(ZoneId.systemDefault()).toInstant()),
                    "Evita 460", 70.0, 1.71, Stream.of(Enfermedad.OBESIDAD, Enfermedad.DIABETES).collect(Collectors.toSet()),
                    Stream.of(Enfermedad.DIABETES).collect(Collectors.toSet()));
            log.info("Preloading " + repository.save(newPaciente));
        };
    }
}
