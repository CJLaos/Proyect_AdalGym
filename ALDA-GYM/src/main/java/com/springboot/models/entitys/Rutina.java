package com.springboot.models.entitys;

public class Rutina {
	public int id_rutina;
	public String meta_cliente;
	public String day_1;
	public String day_2;
	public String day_3;
	public String day_4;
	public String day_5;
	public Rutina() {
		super();
	}
	public Rutina(int id_rutina, String meta_cliente, String day_1, String day_2, String day_3, String day_4,
			String day_5) {
		super();
		this.id_rutina = id_rutina;
		this.meta_cliente = meta_cliente;
		this.day_1 = day_1;
		this.day_2 = day_2;
		this.day_3 = day_3;
		this.day_4 = day_4;
		this.day_5 = day_5;
	}
	public int getId_rutina() {
		return id_rutina;
	}
	public void setId_rutina(int id_rutina) {
		this.id_rutina = id_rutina;
	}
	public String getMeta_cliente() {
		return meta_cliente;
	}
	public void setMeta_cliente(String meta_cliente) {
		this.meta_cliente = meta_cliente;
	}
	public String getDay_1() {
		return day_1;
	}
	public void setDay_1(String day_1) {
		this.day_1 = day_1;
	}
	public String getDay_2() {
		return day_2;
	}
	public void setDay_2(String day_2) {
		this.day_2 = day_2;
	}
	public String getDay_3() {
		return day_3;
	}
	public void setDay_3(String day_3) {
		this.day_3 = day_3;
	}
	public String getDay_4() {
		return day_4;
	}
	public void setDay_4(String day_4) {
		this.day_4 = day_4;
	}
	public String getDay_5() {
		return day_5;
	}
	public void setDay_5(String day_5) {
		this.day_5 = day_5;
	}
	
	
}
