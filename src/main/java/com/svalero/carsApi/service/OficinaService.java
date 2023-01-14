package com.svalero.carsApi.service;

import com.svalero.carsApi.domain.Ciudad;
import com.svalero.carsApi.domain.Oficina;

import java.util.List;

public interface OficinaService {

    List<Oficina> listar();
    Oficina añadirOficina (Oficina oficina, Ciudad ciudad);
    Oficina eliminarOficina(long id);
    /*
    Oficina modificarOficina(long id, Oficina oficina);

     */


}
