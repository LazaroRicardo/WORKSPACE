package com.ricardo.bbdd;

import java.util.ArrayList;

import com.ricardo.modelo.Cancion;

public class BBDDCanciones {

	//necesito almacenar las canciones en una lista
	public ArrayList<Cancion>canciones = new ArrayList<Cancion>();
	
	public BBDDCanciones() {
		this.fillCanciones();
	}
	
	private boolean fillCanciones() {
		canciones.add(new Cancion(1, "waka-waka", "Shakira", null));
		canciones.add(new Cancion(2, "Luisa", "l@l.es", null));
		canciones.add(new Cancion(3, "Mordor", "m@m.es", null));

		return true;
	}
	
	// metodo para que nos ense�e un usuario concreto en funcion de su id:
	// Obtener usuario usuario por su id:
	// Si el usuario no existe nos vevuuelve un null:
	public Cancion getUsuarioById(int id) {
		Cancion cancionADevolver = null;
		// buscamos entre cada usuario y comparamos con el id que se le indica al
		// navegador:
		for (Cancion unaCancion : canciones) {
			if (unaCancion.getId() == id) {
				cancionADevolver = unaCancion;
				// break para que el for deje de buscar al encontrar el resultado esperado.
				break;
			}
		}
		return cancionADevolver;
	}	
}