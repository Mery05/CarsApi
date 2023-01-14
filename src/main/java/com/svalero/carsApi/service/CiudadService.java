package com.svalero.carsApi.service;

import com.svalero.carsApi.domain.Ciudad;

import java.util.List;

public interface CiudadService {
    List<Ciudad> listar();
    Ciudad buscarPorId(long id);
    void añadirCiudad (Ciudad ciudad);
}
