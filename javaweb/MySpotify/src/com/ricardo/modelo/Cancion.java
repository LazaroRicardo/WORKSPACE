package com.ricardo.modelo;

public class Cancion {

	 private int id;
	 private String titulo;
	 private String autor;
	 private String imagen;
	 
	public Cancion(int id, String titulo, String autor, String imagen) {
		this.id = id;
		this.titulo = titulo;
		this.autor = autor;
		this.imagen = imagen;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	} 
}

