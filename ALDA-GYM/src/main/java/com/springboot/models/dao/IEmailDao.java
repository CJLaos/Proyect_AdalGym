package com.springboot.models.dao;

import com.springboot.models.entitys.Cliente;
import com.springboot.models.entitys.Rutina;

public interface IEmailDao {
	
	public Cliente obtenerRutinaPorIdE(Long id);
	void sendEmail(String toAddress, String subject, String body);

	 void enviarDatosPorEmail(Cliente cliente, Rutina rutina);
	 
}
