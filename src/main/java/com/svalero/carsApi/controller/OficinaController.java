package com.svalero.carsApi.controller;

import com.svalero.carsApi.domain.Coche;
import com.svalero.carsApi.domain.Usuario;
import com.svalero.carsApi.exception.*;
import com.svalero.carsApi.service.CiudadService;
import com.svalero.carsApi.service.OficinaService;
import com.svalero.carsApi.domain.Ciudad;
import com.svalero.carsApi.domain.Oficina;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class OficinaController {

    @Autowired
    private OficinaService oficinaService;

    @Autowired
    private CiudadService ciudadService;


    @GetMapping("/oficinas")
    public List<Oficina> getOficina (@RequestParam(name = "ciudad-oficina", required = false, defaultValue = "")
                                         String ciudadId) throws OficinaNotFoundException{
        List<Oficina> oficinas;

        if (ciudadId.equals("")){
            oficinas = oficinaService.listar();
        } else{
            oficinas = oficinaService.listarPorCiudad(Integer.parseInt(ciudadId));
        }
        return oficinas;
    }
    @GetMapping("/oficina/{id}")
    public ResponseEntity<Oficina> getOficina(@PathVariable long id) throws OficinaNotFoundException {
        Oficina oficina = oficinaService.buscarPorId(id);

        return ResponseEntity.ok(oficina);
    }

    @PostMapping("/ciudad/{ciudadId}/oficina")
    public Oficina añadirOficina(@RequestBody Oficina oficina, @PathVariable long ciudadId) throws CiudadNotFoundException{
        Ciudad ciudad = ciudadService.buscarPorId(ciudadId);
        Oficina newOficina = oficinaService.añadirOficina(oficina, ciudad);
        return newOficina;
    }

    @DeleteMapping("/oficinas/{id}")
    public Oficina eliminarOficina(@PathVariable long id) throws OficinaNotFoundException {
        Oficina oficina = oficinaService.eliminarOficina(id);
        return oficina;

    }

    @PutMapping("/oficinas/{id}")
    public Oficina modificarOficina(@PathVariable long id, @RequestBody Oficina oficina) throws OficinaNotFoundException{
        Oficina newOficina = oficinaService.modificarOficina(id, oficina);
        return newOficina;

    }
    @ExceptionHandler(UsuarioNotFoundException.class)
    public ResponseEntity<MensajeError> usuarioNotFoundException(UsuarioNotFoundException bnfe){
        MensajeError mensajeError = new MensajeError(404,bnfe.getMessage());
        return new ResponseEntity(mensajeError, HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(Exception.class)
    public ResponseEntity<MensajeError> handleException(Exception e){
        MensajeError mensajeError = new MensajeError(500,"Internal server Error");
        return new ResponseEntity(mensajeError, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<MensajeError> handleBadRequestException(MethodArgumentNotValidException manve){
        Map<String, String> errors = new HashMap<>();
        manve.getBindingResult().getAllErrors().forEach(error -> {
            String fieldName = ((FieldError) error).getField();
            String message = error.getDefaultMessage();
            errors.put(fieldName, message);
        });
        MensajeError badRequestMensajeError = new MensajeError(400, "Bad Request", errors);
        return new ResponseEntity<>(badRequestMensajeError, HttpStatus.BAD_REQUEST);
    }
}
