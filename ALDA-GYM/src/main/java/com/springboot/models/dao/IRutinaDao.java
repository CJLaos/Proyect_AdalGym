package com.springboot.models.dao;

import java.util.List;

import com.springboot.models.entitys.Cliente;
import com.springboot.models.entitys.Rutina;

public interface IRutinaDao {
	/* METODOS CRUD */
	public List<Rutina> listar();
	public Cliente obtenerRutinaPorId(Long id);
	
	public List<Rutina> listarF();
	public Cliente obtenerRutinaPorIdF(Long id);
}
