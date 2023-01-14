package com.svalero.carsApi.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity (name = "coche")
public class Coche {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column
    private String marca;
    @Column
    private String matricula;
    @Column
    private boolean disponible;

    @OneToMany(mappedBy = "coche", cascade = CascadeType.ALL)
    private List<Alquiler> alquileres;

}
