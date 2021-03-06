package com.mersedes.dracmagicv3.model;


import javax.persistence.*;

@Entity
@Table(name = "telefono")
public class Telefono {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String telefono;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	@Override
	public String toString() {
		return "Telefono [id=" + id + ", telefono=" + telefono + "]";
	}
	
	

}
