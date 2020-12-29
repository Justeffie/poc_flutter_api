package com.poc.flutter.server.flutter_poc_api.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;
import java.util.Set;

@Entity(name = "paciente")
@Table(name = "PACIENTE")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Paciente {

    @Id
    @GeneratedValue
    @Column(name = "ID")
    private Long id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "APELLIDO")
    private String apellido;

    @Column(name = "DNI")
    private int dni;

    @Column(name = "FECHA_NACIMIENTO")
    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(shape = JsonFormat.Shape.NUMBER_INT)
    private Date fechaNacimiento;

    @Column(name = "DOMICILIO")
    private String domicilio;

    @Column(name = "PESO")
    private double peso;

    @Column(name = "ALTURA")
    private double altura;

    @ElementCollection(fetch = FetchType.LAZY, targetClass = Enfermedad.class)
    @CollectionTable(name = "PACIENTE_PREEXISTENTES",
            joinColumns = @JoinColumn(name = "PACIENTE_ID", foreignKey = @ForeignKey(name = "PACPRE$PACIENTE")),
            foreignKey = @ForeignKey(name = "PACPRE$ENFERMEDAD"))
    @Column(name = "ENFERMEDAD_ID")
    private Set<Enfermedad> enfermedadesPreexistentes;

    @ElementCollection(fetch = FetchType.LAZY, targetClass = Enfermedad.class)
    @CollectionTable(name = "PACIENTE_ANTECEDENTES",
            joinColumns = @JoinColumn(name = "PACIENTE_ID", foreignKey = @ForeignKey(name = "PACENF$PACIENTE")),
            foreignKey = @ForeignKey(name = "PACENF$ENFERMEDAD"))
    @Column(name = "ENFERMEDAD_ID")
    private Set<Enfermedad> enfermedadesAntecedentesFamiliares;

}
