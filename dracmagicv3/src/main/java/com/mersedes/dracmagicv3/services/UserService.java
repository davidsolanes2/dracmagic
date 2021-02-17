package com.mersedes.dracmagicv3.services;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetails;

import com.mersedes.dracmagicv3.model.User;

public interface UserService {
	
	public void guardar(User user);
	public void eliminar(Integer idUser);
	List<User> buscarTodos();
	List<User> buscarRegistrados();
	User buscarPorId(Integer idUser);
	User buscarPorFirstName(String firstName);
	int bloquear(int idUser);
	int activar(int idUser);
	UserDetails loadUserByEmail(String email);
	User buscarPorEmail(String email);
}
