package com.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import com.springboot.models.dao.ClienteDaoImpl;

import com.springboot.models.entitys.Cliente;


@Controller
public class ClienteController {
	@Autowired
	private ClienteDaoImpl dao;
	
	
	@GetMapping("/viewClientes")
	public String index(Model modelo) {
		List<Cliente>lista = dao.listar();
		modelo.addAttribute("listaClientes", lista);
		return "viewClientes";
	}
	

	@GetMapping("/nuevocliente")
	public String nuevo (Model modelo) {
		modelo.addAttribute("cliente", new Cliente());
		

		return "viewNuevoCliente";
	}
	
	@PostMapping("/guardarcliente")
	public String guardar (@ModelAttribute Cliente cliente) {
		dao.guardar(cliente);
		 
		return "redirect:/viewClientes";
	}
	
		@GetMapping("/editarCliente/{idcliente}")
	    public String mostrarFormularioEditar(@PathVariable("idcliente") Long idcliente, Model model) {
	        Cliente cliente = dao.obtenerClientePorId(idcliente);
	        model.addAttribute("cliente", cliente);
	        return "editarCliente"; // Reemplaza con el nombre de tu página de formulario de edición
	    }

	    @PostMapping("/guardarCliente")
	    public String guardarCliente(@ModelAttribute("cliente") Cliente cliente) {
	        dao.actualizarcliente(cliente);
	        return "redirect:/viewClientes"; // Redirigir a la lista de CLientes después de editar
	    }

	    @GetMapping("/borrarCliente/{idcliente}")
	    public String borrarCliente(@PathVariable("idcliente") Long idcliente) {
	        dao.borrarcliente(idcliente);
	        return "redirect:/viewClientes"; // Redirigir a la lista de CLientes después de borrar
	    
	}
	    
	    
	    // Vistas del cliente controlladores
	    // Controlador Listar
	    
	    @GetMapping("/viewClienteF/{idcliente}")
		public String index(@PathVariable("idcliente") Long idcliente, Model modelo) {
			Cliente cliente = dao.obtenerClientePorId(idcliente);
			
			modelo.addAttribute("listaClienteF", cliente);
			return "viewClienteF";
		}
	    // Controlador Editar
	    
	   
		
	    @GetMapping("/editarClienteF/{idcliente}")
	    public String mostrarFormularioEditarF(@PathVariable("idcliente") Long idcliente, Model model) {
	        Cliente cliente = dao.obtenerClientePorId(idcliente);
	        model.addAttribute("cliente", cliente);
	        return "editarClienteF"; // Reemplaza con el nombre de tu página de formulario de edición
	    }	
	    
	    @PostMapping("/guardarClienteF")
	    public String guardarFCliente(@ModelAttribute("cliente") Cliente cliente) {
	        dao.actualizarclienteF(cliente);
	        Long idcliente = (long) cliente.getIdcliente(); // Obtén el ID del cliente actualizado
	        return "redirect:/viewClienteF/" + idcliente; // Redirigir a la lista de docentes después de editar
	    }
	  
	    
	    /*
	    @PostMapping("/guardarFCliente/{idcliente}")
	    public String guardarFCliente(@PathVariable("idcliente") Long idcliente, Model model) {
	        Cliente cliente = dao.obtenerClientePorId(idcliente);
	    	
	        dao.actualizarclienteF(cliente);
	        return "redirect:/viewClienteF/{idcliente}"; // Redirigir a la lista de docentes después de editar
	    }*/
	    /*
	    @PostMapping("/guardarFCliente/{idcliente}")
	    public String guardarFCliente(@PathVariable("idcliente") Long idcliente, Model model) {
	        Cliente cliente = dao.obtenerClientePorId(idcliente);
	    	
	        dao.actualizarclienteF(cliente);
	        return "redirect:/viewClienteF/{idcliente}"; // Redirigir a la lista de docentes después de editar
	    }*/
	    /*
	    @PostMapping("/guardarFCliente/{idcliente}")
	    public String guardarFCliente(@PathVariable("idcliente") Long idcliente, Model model) {
	        Cliente cliente = dao.obtenerClientePorId(idcliente);
	    	
	        dao.actualizarclienteF(cliente);
	        return "redirect:/viewClienteF/{idcliente}"; // Redirigir a la lista de docentes después de editar
	    }*/
	    /*
	    @PostMapping("/guardarFCliente/{idcliente}")
	    public String guardarFCliente(@PathVariable("idcliente") Long idcliente, Model model) {
	        Cliente cliente = dao.obtenerClientePorId(idcliente);
	    	
	        dao.actualizarclienteF(cliente);
	        return "redirect:/viewClienteF/{idcliente}"; // Redirigir a la lista de docentes después de editar
	    }*/
	    /*
	    @PostMapping("/guardarFCliente/{idcliente}")
	    public String guardarFCliente(@PathVariable("idcliente") Long idcliente, Model model) {
	        Cliente cliente = dao.obtenerClientePorId(idcliente);
	    	
	        dao.actualizarclienteF(cliente);
	        return "redirect:/viewClienteF/{idcliente}"; // Redirigir a la lista de docentes después de editar
	    }*/
	    /*
	    @PostMapping("/guardarFCliente/{idcliente}")
	    public String guardarFCliente(@PathVariable("idcliente") Long idcliente, Model model) {
	        Cliente cliente = dao.obtenerClientePorId(idcliente);
	    	
	        dao.actualizarclienteF(cliente);
	        return "redirect:/viewClienteF/{idcliente}"; // Redirigir a la lista de docentes después de editar
	    }*/
	    /*
	    @PostMapping("/guardarFCliente/{idcliente}")
	    public String guardarFCliente(@PathVariable("idcliente") Long idcliente, Model model) {
	        Cliente cliente = dao.obtenerClientePorId(idcliente);
	    	
	        dao.actualizarclienteF(cliente);
	        return "redirect:/viewClienteF/{idcliente}"; // Redirigir a la lista de docentes después de editar
	    }*/

	    
	    // 
	    
	    
	
	
}
