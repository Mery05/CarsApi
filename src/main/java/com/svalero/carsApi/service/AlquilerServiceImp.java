package com.svalero.carsApi.service;

import com.svalero.carsApi.domain.Alquiler;
import com.svalero.carsApi.domain.Coche;
import com.svalero.carsApi.domain.Usuario;
import com.svalero.carsApi.repository.AlquilerRepository;
import com.svalero.carsApi.repository.CocheRepository;
import com.svalero.carsApi.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlquilerServiceImp implements AlquilerService{

    @Autowired
    private AlquilerRepository alquilerRepository;
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private CocheRepository cocheRepository;

    @Override
    public List<Alquiler> listar() {
        return alquilerRepository.findAll();
    }

    @Override
    public Alquiler añadirAlquiler(Alquiler alquiler, Usuario usuario, Coche coche) {
        //Usuario idUsuario =usuarioRepository.findById(usuario);
        //cocheService.buscarPorId(coche);

        alquiler.setUsuario(usuario);
        alquiler.setCoche(coche);
        //alquiler.setCoche(coche);
        return alquilerRepository.save(alquiler);
    }


    @Override
    public Alquiler eliminarAlquiler(long id) {
        Alquiler alquiler = alquilerRepository.findById(id);
        alquilerRepository.delete(alquiler);
        return alquiler;
    }

    @Override
    public Alquiler modificarAlquiler(long id, Alquiler newAlquiler) {
        Alquiler alquiler = alquilerRepository.findById(id);
        alquiler.setFechaInicio(newAlquiler.getFechaInicio());
        alquiler.setFechaFin(newAlquiler.getFechaFin());
        //alquiler.setCoche(newAlquiler.getCoche());
        alquiler.setUsuario(newAlquiler.getUsuario());


        return alquilerRepository.save(alquiler);

    }
}
