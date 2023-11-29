package com.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.springboot.models.dao.EntrenadorDaoImpl;
import com.springboot.models.entitys.Entrenador;

@Controller
public class EntrenadorController {
	@Autowired
	private EntrenadorDaoImpl dao;
	
	@GetMapping("/viewIndex")
	public String index(Model modelo) {
		List<Entrenador>lista = dao.listar();
		modelo.addAttribute("listaEntrenador", lista);
		return "viewIndex";
	}

	@GetMapping("/nuevo")
	public String nuevo (Model modelo) {
		modelo.addAttribute("entrenador", new Entrenador());
		return "viewNuevo";
	}
	
	@PostMapping("/guardar")
	public String guardar (@ModelAttribute Entrenador entrenador) {
		dao.guardar(entrenador);
		
		return "redirect:/viewIndex";
	}
	
		@GetMapping("/editar/{idtrainer}")
	    public String mostrarFormularioEditar(@PathVariable("idtrainer") Long idtrainer, Model model) {
	        Entrenador entrenador = dao.obtenerEntrenadorPorId(idtrainer);
	        model.addAttribute("entrenador", entrenador);
	        return "editar"; // Reemplaza con el nombre de tu página de formulario de edición
	    }

	    @PostMapping("/guardarEdicion")
	    public String guardarEdicion(@ModelAttribute("entrenador") Entrenador entrenador) {
	        dao.actualizar(entrenador);
	        return "redirect:/viewIndex"; // Redirigir a la lista de docentes después de editar
	    }

	    @GetMapping("/borrar/{idtrainer}")
	    public String borrarDocente(@PathVariable("idtrainer") Long idtrainer) {
	        dao.borrar(idtrainer);
	        return "redirect:/viewIndex"; // Redirigir a la lista de docentes después de borrar
	    
	}
	
	
	
}
