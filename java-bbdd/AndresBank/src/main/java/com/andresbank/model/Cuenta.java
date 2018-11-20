package com.andresbank.model;

public class Cuenta {

	private int cid; 
	private String nombre;
	private int saldo;
	private int numero_cuenta;
	
	public Cuenta(int cid, String nombre, int saldo, int numero_cuenta) {
		
		this.cid = cid;
		this.nombre = nombre;
		this.saldo = saldo;
		this.numero_cuenta = numero_cuenta;
	}

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getSaldo() {
		return saldo;
	}

	public void setSaldo(int saldo) {
		this.saldo = saldo;
	}

	public int getNumero_cuenta() {
		return numero_cuenta;
	}

	public void setNumero_cuenta(int numero_cuenta) {
		this.numero_cuenta = numero_cuenta;
	}
}
