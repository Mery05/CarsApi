package com.svalero.carsApi.service;

import com.svalero.carsApi.domain.Usuario;
import com.svalero.carsApi.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UsuarioServiceImp implements UsuarioService{

    @Autowired
    private UsuarioRepository usuarioRepository;
    @Override
    public List<Usuario> listar() {
        return usuarioRepository.findAll();
    }

    @Override
    public Usuario buscarPorId(long id) {
        return usuarioRepository.findById(id);
    }

    @Override
    public void añadirUsuario(Usuario usuario) {
        usuarioRepository.save(usuario);

    }

    @Override
    public Usuario eliminarUsuario(long id) {
        Usuario usuario = usuarioRepository.findById(id);

        usuarioRepository.delete(usuario);
        return usuario;
    }

    @Override
    public Usuario modificarUsuario(long id, Usuario newUsuario) {
        Usuario usuario = usuarioRepository.findById(id);
        usuario.setDni(newUsuario.getDni());
        usuario.setNombre(newUsuario.getNombre());
        usuario.setApellidos(newUsuario.getApellidos());
        usuario.setFechaNacimiento(newUsuario.getFechaNacimiento());

        return usuarioRepository.save(usuario);

    }
}
