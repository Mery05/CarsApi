package com.svalero.carsApi.service;


import com.svalero.carsApi.domain.Usuario;

import java.util.List;

public interface UsuarioService {
    List<Usuario> listar();
    Usuario buscarPorId(long id);
    void añadirUsuario (Usuario usuario);
    Usuario eliminarUsuario (long id);
    Usuario modificarUsuario (long id, Usuario usuario);
}
