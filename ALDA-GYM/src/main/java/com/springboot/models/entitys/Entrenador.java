package com.springboot.models.entitys;

public class Entrenador {
	
	private int idtrainer;
	private String nombretrainer;
	private String apellidotrainer;
	private Double sueldotrainer;
	private int telefonotrainer;
	
	
	/* Constructor vacio */
	public Entrenador() {
		super();
	}
	/* Constructor con parametros */

	public Entrenador(int idtrainer, String nombretrainer, String apellidotrainer, Double sueldotrainer,
			int telefonotrainer) {
		super();
		this.idtrainer = idtrainer;
		this.nombretrainer = nombretrainer;
		this.apellidotrainer = apellidotrainer;
		this.sueldotrainer = sueldotrainer;
		this.telefonotrainer = telefonotrainer;

	}

	public int getIdtrainer() {
		return idtrainer;
	}

	public void setIdtrainer(int idtrainer) {
		this.idtrainer = idtrainer;
	}

	public String getNombretrainer() {
		return nombretrainer;
	}

	public void setNombretrainer(String nombretrainer) {
		this.nombretrainer = nombretrainer;
	}

	public String getApellidotrainer() {
		return apellidotrainer;
	}

	public void setApellidotrainer(String apellidotrainer) {
		this.apellidotrainer = apellidotrainer;
	}

	public Double getSueldotrainer() {
		return sueldotrainer;
	}

	public void setSueldotrainer(Double sueldotrainer) {
		this.sueldotrainer = sueldotrainer;
	}

	public int getTelefonotrainer() {
		return telefonotrainer;
	}

	public void setTelefonotrainer(int telefonotrainer) {
		this.telefonotrainer = telefonotrainer;
	}

	

	
	
	/* Metodos Get And Set  */
	
	
	
	
	
	
	

}
