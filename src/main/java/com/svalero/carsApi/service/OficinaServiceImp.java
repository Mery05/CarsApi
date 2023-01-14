package com.svalero.carsApi.service;

import com.svalero.carsApi.domain.Ciudad;
import com.svalero.carsApi.domain.Oficina;
import com.svalero.carsApi.repository.OficinaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OficinaServiceImp implements OficinaService{

    @Autowired
    private OficinaRepository oficinaRepository;



    @Override
    public List<Oficina> listar() {
        return oficinaRepository.findAll();
    }

    @Override
    public Oficina añadirOficina(Oficina oficina, Ciudad ciudad) {
        oficina.setCiudad(ciudad);

        return oficinaRepository.save(oficina);
    }

    @Override
    public Oficina eliminarOficina(long id) {
        Oficina oficina = oficinaRepository.findByid(id);
        oficinaRepository.delete(oficina);

        return oficina;
    }
/*
    @Override
    public Oficina modificarOficina(long id, Oficina newOficina) {
        Oficina oficina = oficinaRepository.findByid(id);
        oficina
        return null;
    }

 */
}
