package com.ricardo.modelos;

public class Habitacion {

	private int hid;
	private String calle;
	private int metros2;
	
	
	public Habitacion(int hid, String calle, int metros2) {
		this.hid = hid;
		this.calle = calle;
		this.metros2 = metros2;
		
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

	public int getMetros2() {
		return metros2;
	}

	public void setMetros2(int metros2) {
		this.metros2 = metros2;
	}
	
	public boolean esValido() {
		boolean esValid = true;
		
		// matches es para poder meter caracteres específicos y que no se puedan poner
		// nº en el nombre:
		if (this.calle == null || this.calle.equals("") )
			esValid = false;
		
		if (!this.calle.matches("([a-zA-Z ]*)[0-9](.*)?") )
			esValid = false;
		
		if (this.metros2 <=0)
			esValid = false;

		return esValid;
	}
	
}
