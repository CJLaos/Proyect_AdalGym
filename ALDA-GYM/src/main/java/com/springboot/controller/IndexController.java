package com.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {
	@GetMapping("/rutinas")
    public String mostrarRutinas() {
        return "rutinasIndex";
    }
}
