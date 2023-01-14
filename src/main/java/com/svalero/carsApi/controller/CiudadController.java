package com.svalero.carsApi.controller;

import com.svalero.carsApi.exception.CiudadNotFoundException;
import com.svalero.carsApi.exception.CocheNotFoundException;
import com.svalero.carsApi.exception.MensajeError;
import com.svalero.carsApi.service.CiudadService;
import com.svalero.carsApi.domain.Ciudad;
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
public class CiudadController {
    @Autowired
    private CiudadService ciudadService;


    @GetMapping("/ciudades")
    public ResponseEntity<List<Ciudad>> getCiudades(){

        return ResponseEntity.ok(ciudadService.listar());
    }

    @GetMapping("/ciudad/{id}")
    public ResponseEntity<Ciudad> getCiudad(@PathVariable long id) throws CiudadNotFoundException {
        Ciudad ciudad = ciudadService.buscarPorId(id);

        return ResponseEntity.ok(ciudad);
    }



    @PostMapping("/ciudades")
    public void añadirCiudad(@RequestBody Ciudad ciudad){

        ciudadService.añadirCiudad(ciudad);
    }

    @ExceptionHandler(CiudadNotFoundException.class)
    public ResponseEntity<MensajeError> ciudadNotFoundException(CiudadNotFoundException bnfe){
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
