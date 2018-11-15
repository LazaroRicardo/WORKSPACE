package com.ricardo.modelos;

//modelo de MVC:
public class Usuario {

	// propiedades en min�scula:
	private int id;
	private String name;
	private String email;
	private String password;
	private Habitacion habitacion;

	public Usuario(int id, String name, String email, String password, Habitacion habitacion) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
		this.habitacion = habitacion;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Habitacion getHabitacion() {
		return habitacion;
	}

	public void setHabitacion(Habitacion habitacion) {
		this.habitacion = habitacion;
	}

	// Valida los campos del nuevo usuario si los campos son correctos, bien
	// formados y tienen valor:
	public boolean esValido(String confirmpassword) {
		boolean esValid = true;
		
		// matches es para poder meter caracteres espec�ficos y que no se puedan poner
		// n� en el nombre:
		if (this.name == null || this.name.equals("") || this.name.matches("(.*)?[0-9](.*)?"))
			esValid = false;
		
		// <=0 es que si el @ est� al principio o no existe que tambi�n sea false:
				if (this.email == null || this.email.equals("") || this.email.indexOf("@") <= 0)
					esValid = false;

		if (this.password == null || this.password.equals(""))
			esValid = false;
		// confirmacion de password lo hemos creado como parametro para no crearlo al
		// modelo usuario y as� poder enlazarlo al password:
		if (!this.password.equals(confirmpassword))
			esValid = false;

		return esValid;
	}
}
