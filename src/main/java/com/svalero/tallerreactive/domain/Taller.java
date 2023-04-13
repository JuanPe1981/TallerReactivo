package com.svalero.tallerreactive.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(value = "talleres")
public class Taller {
    @Id
    private String id;
    @Field
    private String nombreTaller;
    @Field
    private String direccion;
    @Field
    private String ciudad;
    @Field
    private String telefono;
    @Field
    private String email;
    @Field
    private LocalTime horaApertura;
    @Field
    private LocalTime horaCierre;
    @Field
    private LocalDate fechaInicio;
}
