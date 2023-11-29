package com.springboot.models.dao;

import java.util.List;

import com.springboot.models.entitys.Entrenador;

public interface IEntrenadorDao {

	/*METODOS CRUD*/
	public List<Entrenador>listar();
	
	public int guardar (Entrenador entrenador);
	
	 public Entrenador obtenerEntrenadorPorId(Long id);

	   public int actualizar(Entrenador entrenador);

	 public   int borrar(Long id);

	
	
	
}
