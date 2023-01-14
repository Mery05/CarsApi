package com.svalero.carsApi.controller;

import com.svalero.carsApi.service.CiudadService;
import com.svalero.carsApi.service.OficinaService;
import com.svalero.carsApi.domain.Ciudad;
import com.svalero.carsApi.domain.Oficina;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OficinaController {

    @Autowired
    private OficinaService oficinaService;

    @Autowired
    private CiudadService ciudadService;

    @GetMapping("/oficinas")
    public ResponseEntity<List<Oficina>> getOficinas(){

        return ResponseEntity.ok(oficinaService.listar());
    }

    @PostMapping("/ciudad/{ciudadId}/oficina")
    public Oficina añadirOficina(@RequestBody Oficina oficina, @PathVariable long ciudadId){
        Ciudad ciudad = ciudadService.buscarPorId(ciudadId);
        Oficina newOficina = oficinaService.añadirOficina(oficina, ciudad);
        return newOficina;
    }

}
