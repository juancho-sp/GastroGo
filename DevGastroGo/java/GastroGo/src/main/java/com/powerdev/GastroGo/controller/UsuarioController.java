package com.powerdev.GastroGo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.powerdev.GastroGo.model.Usuario;
import com.powerdev.GastroGo.service.UsuarioService;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {
	
	@Autowired
	private UsuarioService usuarioService;
	
	@GetMapping
	public String listarUsuarios(Model model) {		
		model.addAttribute("usuarios", usuarioService.listarTodas());
		return "usuario-list";
	}
	
    @GetMapping("/nuevo")
    public String mostrarFormularioNuevoUsuario(Model model) {
        model.addAttribute("usuario", new Usuario()); 
        return "usuario-form";
    }
	
	@PostMapping
	public String guardarUsuario(Usuario usuario) {
		usuarioService.guardar(usuario);
		return "redirect:/usuario";
	}
	
	@GetMapping("/editar/{id}")
	public String mostrarFormularioEditarUsuario(@PathVariable Long id, Model model) {
		model.addAttribute("usuario", usuarioService.obtenerPorId(id));
		return "usuario-form";
	}
	
	@GetMapping("/eliminar/{id}")
	public String eliminarUsuario(@PathVariable Long id) {
	    usuarioService.eliminar(id);
	    return "redirect:/usuario";
	}
}
