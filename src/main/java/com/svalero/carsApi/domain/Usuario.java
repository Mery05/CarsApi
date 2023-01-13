package com.svalero.carsApi.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity (name = "usuario")
public class Usuario {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private long id;
    @Column
    private String dni;
    @Column
    private String nombre;
    @Column
    private String apellidos;
    @Column (name = "fecha_nacimiento")
    private LocalDate fechaNacimiento;
}
