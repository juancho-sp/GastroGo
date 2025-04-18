package com.powerdev.GastroGo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.powerdev.GastroGo.model.Usuario;

public interface UsuarioRepository extends JpaRepository <Usuario, Long>{ //el JpaRepository es de spring
	
}
