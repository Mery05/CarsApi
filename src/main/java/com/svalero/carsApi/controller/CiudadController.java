package com.svalero.carsApi.controller;

import com.svalero.carsApi.service.CiudadService;
import com.svalero.carsApi.domain.Ciudad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CiudadController {
    @Autowired
    private CiudadService ciudadService;


    @GetMapping("/ciudades")
    public ResponseEntity<List<Ciudad>> getCiudades(){

        return ResponseEntity.ok(ciudadService.listar());
    }

    @GetMapping("/ciudad/{id}")
    public ResponseEntity<Ciudad> getCiudad(@PathVariable long id) {
        Ciudad ciudad = ciudadService.buscarPorId(id);

        return ResponseEntity.ok(ciudad);
    }

    @PostMapping("/ciudades")
    public void añadirCiudad(@RequestBody Ciudad ciudad){

        ciudadService.añadirCiudad(ciudad);
    }


}
