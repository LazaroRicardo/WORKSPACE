package com.andresbank.model;

public class Nomina {

	private int nid; 
	private String nombre;
	private int valor;
	
	public Nomina(int nid, String nombre, int valor) {
		this.nid = nid;
		this.nombre = nombre;
		this.valor = valor;
	}

	public int getNid() {
		return nid;
	}

	public void setNid(int nid) {
		this.nid = nid;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getValor() {
		return valor;
	}

	public void setValor(int valor) {
		this.valor = valor;
	}
}
