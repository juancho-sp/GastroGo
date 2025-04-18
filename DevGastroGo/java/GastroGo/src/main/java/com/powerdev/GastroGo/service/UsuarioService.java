package com.powerdev.GastroGo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.powerdev.GastroGo.repository.UsuarioRepository;
import com.powerdev.GastroGo.model.Usuario;

@Service
public class UsuarioService {
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	//listar usuarios
	public List<Usuario> listarTodas() {
		return usuarioRepository.findAll();
	}
	//agregar nuevo usuario
	public Usuario guardar(Usuario usuario) {
		return usuarioRepository.save(usuario);		
	}
	//buscar por id
	public Usuario obtenerPorId(Long id) {
		return usuarioRepository.findById(id).orElse(null);		
	}
	//eliminar usuario
	public void eliminar(Long id) {
        usuarioRepository.deleteById(id);
    }	
}
