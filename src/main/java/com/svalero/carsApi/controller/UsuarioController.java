package com.svalero.carsApi.controller;

import com.svalero.carsApi.exception.CocheNotFoundException;
import com.svalero.carsApi.exception.MensajeError;
import com.svalero.carsApi.exception.UsuarioNotFoundException;
import com.svalero.carsApi.service.UsuarioService;
import com.svalero.carsApi.domain.Usuario;
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
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;


    @GetMapping("/usuarios")
    public ResponseEntity<List<Usuario>> getUsuarios(){

        return ResponseEntity.ok(usuarioService.listar());
    }

    @GetMapping("/usuario/{id}")
    public ResponseEntity<Usuario> getUsuario(@PathVariable long id) throws UsuarioNotFoundException{
        Usuario usuario = usuarioService.buscarPorId(id);

        return ResponseEntity.ok(usuario);
    }

    @PostMapping("/usuarios")
    public void añadirUsuario(@RequestBody Usuario usuario){
        usuarioService.añadirUsuario(usuario);
    }

    @DeleteMapping("/usuarios/{id}")
    public Usuario eliminarUsuario(@PathVariable long id) throws UsuarioNotFoundException{
        Usuario usuario = usuarioService.eliminarUsuario(id);
        return usuario;

    }

    @PutMapping("/usuarios/{id}")
    public Usuario modificarUsuario(@PathVariable long id, @RequestBody Usuario usuario)throws UsuarioNotFoundException{
        Usuario newUsuario = usuarioService.modificarUsuario(id,usuario);
        return newUsuario;

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
