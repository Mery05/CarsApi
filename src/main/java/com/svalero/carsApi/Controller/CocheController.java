package com.svalero.carsApi.Controller;

import com.svalero.carsApi.Service.CocheService;
import com.svalero.carsApi.domain.Coche;
import com.svalero.carsApi.repository.CocheRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CocheController {

    @Autowired
    private CocheService cocheService;

    @GetMapping("/coches")
    public ResponseEntity<List<Coche>> getCoches(){

        return ResponseEntity.ok(cocheService.listar());
    }

    @GetMapping("/coche/{id}")
    public ResponseEntity<Coche> getCoche(@PathVariable long id) {
        Coche coche = cocheService.buscarPorId(id);

        return ResponseEntity.ok(coche);
    }

    @PostMapping("/coches")
    public void añadirCoche(@RequestBody Coche coche){
        cocheService.añadirCoche(coche);
    }

    @DeleteMapping("/coches/{id}")
    public Coche eliminarCoche(@PathVariable long id){
        Coche coche = cocheService.eliminarCoche(id);
        return coche;

    }

    @PutMapping("/coches/{id}")
    public Coche modificarCoche(@PathVariable long id, @RequestBody Coche coche){
            Coche newCoche = cocheService.modificarCoche(id,coche);
            return newCoche;

    }

}
