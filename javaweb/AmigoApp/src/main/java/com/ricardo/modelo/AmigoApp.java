package com.ricardo.modelo;

public class AmigoApp {
	
	private int id;
	private String name;
	private int edad;
	private String email;
	private boolean alopecia;
	
	public AmigoApp(int id, String name, int edad, String email, boolean alopeciarecibido) {
		this.id = id;
		this.name = name;
		this.edad = edad;
		this.email = email;
		this.alopecia = alopeciarecibido;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean isAlopecia() {
		return alopecia;
	}

	public void setAlopecia(boolean alopecia) {
		this.alopecia = alopecia;
	}


}
