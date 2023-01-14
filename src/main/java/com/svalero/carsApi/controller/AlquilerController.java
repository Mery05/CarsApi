package com.svalero.carsApi.controller;

import com.svalero.carsApi.exception.CocheNotFoundException;
import com.svalero.carsApi.repository.CocheRepository;
import com.svalero.carsApi.repository.UsuarioRepository;
import com.svalero.carsApi.service.AlquilerService;
import com.svalero.carsApi.domain.Alquiler;
import com.svalero.carsApi.domain.Coche;
import com.svalero.carsApi.domain.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class AlquilerController {
    @Autowired
    private AlquilerService alquilerService;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private CocheRepository cocheRepository;

    @GetMapping("/alquileres")
    public ResponseEntity<List<Alquiler>> getAlquiler(){

        return ResponseEntity.ok(alquilerService.listar());
    }

    @PostMapping("/usuario/{usuarioId}/coche/{cocheId}/alquileres")
    public Alquiler añadirAlquiler(@RequestBody Alquiler alquiler, @PathVariable long usuarioId, @PathVariable long cocheId) throws CocheNotFoundException {
        Usuario usuario = usuarioRepository.findById(usuarioId);
        Coche coche = cocheRepository.findById(cocheId)
                .orElseThrow(CocheNotFoundException::new);

        Alquiler newAlquiler = alquilerService.añadirAlquiler(alquiler, usuario, coche);


        return newAlquiler;
    }

}
