package com.poc.flutter.server.flutter_poc_api.controller;

import com.poc.flutter.server.flutter_poc_api.model.Enfermedad;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
@RequestMapping("/api")
public class EnfermedadController {

    @GetMapping("/enfermedad")
    List<Enfermedad> all() throws InterruptedException {
        Thread.sleep(2000);
        return Stream.of(Enfermedad.values()).collect(Collectors.toList());
    }
}
