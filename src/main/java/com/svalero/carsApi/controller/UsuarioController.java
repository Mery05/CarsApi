package com.svalero.carsApi.controller;

import com.svalero.carsApi.service.UsuarioService;
import com.svalero.carsApi.domain.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;


    @GetMapping("/usuarios")
    public ResponseEntity<List<Usuario>> getUsuarios(){

        return ResponseEntity.ok(usuarioService.listar());
    }

    @GetMapping("/usuario/{id}")
    public ResponseEntity<Usuario> getUsuario(@PathVariable long id) {
        Usuario usuario = usuarioService.buscarPorId(id);

        return ResponseEntity.ok(usuario);
    }

    @PostMapping("/usuarios")
    public void añadirUsuario(@RequestBody Usuario usuario){
        usuarioService.añadirUsuario(usuario);
    }

    @DeleteMapping("/usuarios/{id}")
    public Usuario eliminarUsuario(@PathVariable long id){
        Usuario usuario = usuarioService.eliminarUsuario(id);
        return usuario;

    }

    @PutMapping("/usuarios/{id}")
    public Usuario modificarUsuario(@PathVariable long id, @RequestBody Usuario usuario){
        Usuario newUsuario = usuarioService.modificarUsuario(id,usuario);
        return newUsuario;

    }

}
