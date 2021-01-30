package com.mersedes.dracmagicv3.model;

import java.util.Date;

public class Tutores {
	
	private Integer id;
	private String nombre;
	private String apellidos;
	private Date fecha_alta;
	
	public Tutores(Integer id, String nombre, String apellidos, Date fecha_alta) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.fecha_alta = fecha_alta;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public Date getFecha_alta() {
		return fecha_alta;
	}

	public void setFecha_alta(Date fecha_alta) {
		this.fecha_alta = fecha_alta;
	}

	@Override
	public String toString() {
		return "Tutores [id=" + id + ", nombre=" + nombre + ", apellidos=" + apellidos + ", fecha_alta=" + fecha_alta
				+ "]";
	}
	
	
	
	/*
	 * 
	 * Añadir enum para rol padre o madre
	 * 
	 * */

	
	
}
