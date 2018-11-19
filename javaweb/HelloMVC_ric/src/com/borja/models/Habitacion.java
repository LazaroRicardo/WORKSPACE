package com.borja.models;

public class Habitacion {
	private int hid;
	private String calle;
	private double metros;
	
	public Habitacion(int hid, String calle, double metros) {
		this.hid = hid;
		this.calle = calle;
		this.metros = metros;
	}

	public int getHid() {
		return hid;
	}

	public void setHid(int hid) {
		this.hid = hid;
	}

	public String getCalle() {
		return calle;
	}

	public void setCalle(String calle) {
		this.calle = calle;
	}

	public double getMetros() {
		return metros;
	}

	public void setMetros(double metros) {
		this.metros = metros;
	}

	public boolean esValido() {
		boolean esValid=true;
		
		if(this.calle==null || this.calle.equals("") ) esValid=false;
		
		if( !this.calle.matches("([a-zA-Z ]*)[0-9](.*)?") ) esValid=false;
		
		if(this.metros<=0) esValid=false;
		

		return esValid;
	}
	

}







