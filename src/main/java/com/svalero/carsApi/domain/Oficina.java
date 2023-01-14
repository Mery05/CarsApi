package com.svalero.carsApi.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity (name = "oficina")
public class Oficina {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private long id;
    @Column (name = "num_trabajadores")
    private int numTrabajadores;
    @Column
    private String direccion;
    @Column
    private String telefono;
    @ManyToOne
    @JoinColumn(name = "ciudad_id")
    @JsonBackReference(value = "ciudad-oficina")
    private Ciudad ciudad;




}
