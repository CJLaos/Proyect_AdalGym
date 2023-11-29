package com.springboot.models.entitys;

public class Empleado {
	private int codigo;
	private String nombre;
	private String apellido;
	private String cargo;
	private String sede;
	private int aniosservicio;
	
	
	
	
	public Empleado() {
		super();
	}


	public Empleado(int codigo, String nombre, String apellido, String cargo, String sede, int aniosservicio) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.apellido = apellido;
		this.cargo = cargo;
		this.sede = sede;
		this.aniosservicio = aniosservicio;
	}






	public int getCodigo() {
		return codigo;
	}


	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getApellido() {
		return apellido;
	}


	public void setApellido(String apellido) {
		this.apellido = apellido;
	}


	public String getCargo() {
		return cargo;
	}


	public void setCargo(String cargo) {
		this.cargo = cargo;
	}


	public String getSede() {
		return sede;
	}


	public void setSede(String sede) {
		this.sede = sede;
	}


	public int getAniosservicio() {
		return aniosservicio;
	}


	public void setAniosservicio(int aniosservicio) {
		this.aniosservicio = aniosservicio;
	}


	public int SueldoBasico() {
		if(cargo.equals("jefe"))
			return 5000;
		else if (cargo.equals("analista"))
			return 4000;
		else if (cargo.equals("programador"))
			return 3000;
		else if (cargo.equals("soporte"))
			return 2000;
		else
			return 0;
	}
	
	
	public double BonoSede() {
		if(sede.equals("Miraflores"))
			return SueldoBasico()*0.07;
		else if (sede.equals("Sanisidro"))
			return SueldoBasico()*0.1;
		else if (sede.equals("Magdalena"))
			return SueldoBasico()*0.04;
		else if (sede.equals("JesusMaria"))
			return SueldoBasico()*0.05;
		else
			return 0;
	}
	
	public double BonoAniosServc (){
		if (aniosservicio <=2)
			return SueldoBasico()*0.05;
		else if(aniosservicio > 2 && aniosservicio<=4)
			return SueldoBasico()*0.07;
		else if(aniosservicio > 4)
			return SueldoBasico()*0.1;
		else
			return 0;
	}
	
	
	public double SueldoNeto() {
		return SueldoBasico()+ BonoAniosServc()+ BonoSede();
	}

}
