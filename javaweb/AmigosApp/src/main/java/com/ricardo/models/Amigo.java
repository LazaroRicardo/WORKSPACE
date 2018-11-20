package com.ricardo.models;

public class Amigo {
	private String nombre;
	private String email;
	private int edad;
	private double altura;
	private boolean alopecia;

	public Amigo(String nombre, String email, int edad, double altura, boolean alopecia) {
		super();
		this.nombre = nombre;
		this.email = email;
		this.edad = edad;
		this.altura = altura;
		this.alopecia = alopecia;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public double getAltura() {
		return altura;
	}

	public void setAltura(double altura) {
		this.altura = altura;
	}

	public boolean isAlopecia() {
		return alopecia;
	}

	public void setAlopecia(boolean alopecia) {
		this.alopecia = alopecia;
	}

	public boolean esvalid() {
		// TODO Auto-generated method stub
		boolean esVal = true;

		if (this.email == null || this.email.equals("") || this.email.indexOf("@") <= 0)
			esVal = false;

		if (this.nombre == null || this.nombre.equals("") || this.nombre.matches("(.*)?[0-9](.*)?"))
			esVal = false;

		if (this.edad < 14)
			esVal = false;

		if (this.altura <= 1)
			esVal = false;

		return esVal;
	}

}
