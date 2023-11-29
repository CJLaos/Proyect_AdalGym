package com.springboot.models.entitys;

public class Cliente {

	private int idcliente;
	private String nombrecliente;
	private String apellidocliente;
	private String correocliente;
	private String contraseñacliente;
	private int telefonocliente;
	private float pesocliente;
	private float altura;
	private int id_categoria;
	private int idtrainer;
	private int id_Plan_Aliment;
	private int id_rutina;
	private float imc;

	public Cliente() {
		super();
	}

	
	
	
	public Cliente(int idcliente, String nombrecliente, String apellidocliente, String correocliente,
			String contraseñacliente, int telefonocliente, float pesocliente, float altura, int id_categoria,
			int idtrainer, int id_Plan_Aliment, int id_rutina, float imc) {
		super();
		this.idcliente = idcliente;
		this.nombrecliente = nombrecliente;
		this.apellidocliente = apellidocliente;
		this.correocliente = correocliente;
		this.contraseñacliente = contraseñacliente;
		this.telefonocliente = telefonocliente;
		this.pesocliente = pesocliente;
		this.altura = altura;
		this.id_categoria = id_categoria;
		this.idtrainer = idtrainer;
		this.id_Plan_Aliment = id_Plan_Aliment;
		this.id_rutina = id_rutina;
		this.imc = imc;
	}

	
	
	public int getIdcliente() {
		return idcliente;
	}




	public void setIdcliente(int idcliente) {
		this.idcliente = idcliente;
	}




	public String getNombrecliente() {
		return nombrecliente;
	}




	public void setNombrecliente(String nombrecliente) {
		this.nombrecliente = nombrecliente;
	}




	public String getApellidocliente() {
		return apellidocliente;
	}




	public void setApellidocliente(String apellidocliente) {
		this.apellidocliente = apellidocliente;
	}




	public String getCorreocliente() {
		return correocliente;
	}




	public void setCorreocliente(String correocliente) {
		this.correocliente = correocliente;
	}




	public String getContraseñacliente() {
		return contraseñacliente;
	}




	public void setContraseñacliente(String contraseñacliente) {
		this.contraseñacliente = contraseñacliente;
	}




	public int getTelefonocliente() {
		return telefonocliente;
	}




	public void setTelefonocliente(int telefonocliente) {
		this.telefonocliente = telefonocliente;
	}




	public float getPesocliente() {
		return pesocliente;
	}




	public void setPesocliente(float pesocliente) {
		this.pesocliente = pesocliente;
	}




	public float getAltura() {
		return altura;
	}




	public void setAltura(float altura) {
		this.altura = altura;
	}




	public int getId_categoria() {
		return id_categoria;
	}




	public void setId_categoria(int id_categoria) {
		this.id_categoria = id_categoria;
	}




	public int getIdtrainer() {
		return idtrainer;
	}




	public void setIdtrainer(int idtrainer) {
		this.idtrainer = idtrainer;
	}




	public int getId_Plan_Aliment() {
		return id_Plan_Aliment;
	}




	public void setId_Plan_Aliment(int id_Plan_Aliment) {
		this.id_Plan_Aliment = id_Plan_Aliment;
	}




	public int getId_rutina() {
		return id_rutina;
	}




	public void setId_rutina(int id_rutina) {
		this.id_rutina = id_rutina;
	}




	public float getImc() {
		return imc;
	}




	public void setImc(float imc) {
		this.imc = imc;
	}

// Calculadora IMC


	public float calcularIMC() {
		imc = pesocliente / (altura * altura);
		return imc;
	}

	public String clasificarIMC() {
		return clasificarIMC(imc);
	}

	public String clasificarIMC(float imc) {
		if (imc < 18.5) {
			return "Bajo peso";
		} else if (imc < 25) {
			return "Normal";
		} else if (imc < 30) {
			return "Sobrepeso";
		} else {
			return "Obesidad";
		}
	}

	public float clasificarRutina() {
		return clasificarRutina(imc);
	}

	public float clasificarRutina(float imc) {
		if (imc < 18.5) {
			return 1;
		} else if (imc < 25) {
			return 2;
		} else if (imc < 30) {
			return 3;
		} else {
			return 4;
		}
	}

}
