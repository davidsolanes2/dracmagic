package com.mersedes.dracmagicv3.model;

public class Informes {
	
	private Integer id;
	private String descripcion;
	
	public Informes(Integer id, String descripcion) {
		super();
		this.id = id;
		this.descripcion = descripcion;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Override
	public String toString() {
		return "Informes [id=" + id + ", descripcion=" + descripcion + "]";
	}
	
	

}
