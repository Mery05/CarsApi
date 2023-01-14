package com.svalero.carsApi.service;

import com.svalero.carsApi.domain.Alquiler;
import com.svalero.carsApi.domain.Coche;
import com.svalero.carsApi.domain.Usuario;

import java.util.List;

public interface AlquilerService {

    List<Alquiler> listar();
    Alquiler añadirAlquiler(Alquiler alquiler, Usuario usuario, Coche coche);
    Alquiler eliminarAlquiler(long id);
    Alquiler modificarAlquiler(long id, Alquiler alquiler);

}
