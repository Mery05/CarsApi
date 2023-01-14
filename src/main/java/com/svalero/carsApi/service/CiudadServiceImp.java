package com.svalero.carsApi.service;

import com.svalero.carsApi.domain.Ciudad;
import com.svalero.carsApi.repository.CiudadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CiudadServiceImp implements CiudadService{

    @Autowired
    private CiudadRepository ciudadRepository;
    @Override
    public List<Ciudad> listar() {
        return ciudadRepository.findAll();
    }

    @Override
    public Ciudad buscarPorId(long id) {
        return ciudadRepository.findById(id);
    }

    @Override
    public void añadirCiudad(Ciudad ciudad) {
        ciudadRepository.save(ciudad);


    }
}
