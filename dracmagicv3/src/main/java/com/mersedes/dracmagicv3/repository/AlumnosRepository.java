package com.mersedes.dracmagicv3.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.mersedes.dracmagicv3.model.Alumno;


public interface AlumnosRepository extends JpaRepository<Alumno, Integer> {
	
	Alumno findByNombre(String nombre);
	
	
}
