package com.springboot.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.springboot.models.dao.EmailServiceDaoImpl;
import com.springboot.models.dao.RutinaDaoImpl;
import com.springboot.models.entitys.Cliente;
import com.springboot.models.entitys.Rutina;
import com.springboot.models.dao.ClienteDaoImpl;
@Controller
public class RutinaController {
	@Autowired
	private RutinaDaoImpl dao;
	@Autowired
    private EmailServiceDaoImpl emailService;
	@Autowired
	private ClienteDaoImpl daoE;
	
	@GetMapping("/viewRutina/{id_rutina}")
	public String index(@PathVariable("id_rutina") Long id_rutina, Model modelo) {
		Rutina rutina = dao.obtenerRutinaPorId(id_rutina);
		
		modelo.addAttribute("listaRutina", rutina);
		return "viewRutina";
	}
	
	@GetMapping("/viewRutinaF/{id_rutina}")
	public String indexF(@PathVariable("id_rutina") Long id_rutina, Model modelo) {
		Rutina rutina = dao.obtenerRutinaPorIdF(id_rutina);
		
		modelo.addAttribute("listaRutina", rutina);
		return "viewRutinaF";
	}
	
	
	
	  @GetMapping("/enviar-datos-por-email/{idcliente}")
	    public ResponseEntity<String> enviarDatosPorEmail(@PathVariable Long idcliente) {
	        Cliente cliente = daoE.obtenerClientePorId(idcliente);

	        // Enviar el correo
	        emailService.enviarDatosPorEmail(cliente);

	        return ResponseEntity.ok("Correo enviado exitosamente") ;
	    }
}
