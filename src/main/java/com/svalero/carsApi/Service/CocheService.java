package com.svalero.carsApi.Service;

import com.svalero.carsApi.domain.Coche;

import java.util.List;

public interface CocheService {

    List<Coche> listar();
    Coche buscarPorId(long id);
    void añadirCoche (Coche coche);
    Coche eliminarCoche (long id);
    Coche modificarCoche (long id, Coche coche);


}
