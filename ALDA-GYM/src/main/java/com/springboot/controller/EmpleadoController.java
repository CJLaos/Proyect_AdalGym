package com.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.springboot.models.entitys.Empleado;


@Controller
public class EmpleadoController {

	@GetMapping("/empleado")
	public String abrir(Model modelo) {
		modelo.addAttribute("empleado",new Empleado());
		return "Empleadofrm";
	}
	
	@PostMapping("/procesar")
	public String procesar(Model modelo, Empleado obj) {
		modelo.addAttribute("acodigo", obj.getCodigo());
		modelo.addAttribute("anombre", obj.getNombre());
		modelo.addAttribute("aapellido", obj.getApellido());
		modelo.addAttribute("acargo", obj.getCargo());
		modelo.addAttribute("asede", obj.getSede());
		modelo.addAttribute("aaniosservicio", obj.getAniosservicio());
		modelo.addAttribute("asueldobasico",obj.SueldoBasico());
		modelo.addAttribute("abonoaniosservc",obj.BonoAniosServc());
		modelo.addAttribute("abonosede",obj.BonoSede());
		modelo.addAttribute("asueldoneto",obj.SueldoNeto());
		
		return "otro";
	}
	
}
