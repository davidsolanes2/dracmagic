package com.mersedes.dracmagicv3.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.mersedes.dracmagicv3.model.User;
import com.mersedes.dracmagicv3.services.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService serviceUser;
	
	/*
	 * Method that show the list of users without pagination
	 * @param model
	 * @param page
	 * @return
	 * */
	@GetMapping("/index")
	public String mostrarIndex(Model model) {
		List<User> lista = serviceUser.buscarRegistrados();
		model.addAttribute("user", lista);
		return "user/listUser";
	}
	
	/*
	 * Method to remove a user form database
	 * @param idUser
	 * @param attributes
	 * @return
	 * */
	@GetMapping("delete/{id}")
	public String eliminar(@PathVariable("id") int idUser, RedirectAttributes attributes) {
		serviceUser.eliminar(idUser);
		
		attributes.addFlashAttribute("msg", "El usuario fue eliminado!");
		return "redirect:/user/index";
	}
	
	/*
	 * Method to activate a user
	 * @param idUser
	 * @param attributes
	 * @return
	 * */
	@GetMapping("/unlock/{id}")
	public String activar(@PathVariable("id") int idUser, RedirectAttributes attributes) {
		serviceUser.activar(idUser);
		
		attributes.addFlashAttribute("msg", "El ususario fue activado y ahora tiene acceso al sistema");
		return "redirect:/user/index";
	}
	
	/*
	 * Method to lock a user
	 * @param idUser
	 * @param attributes
	 * @return
	 * */
	@GetMapping("/lock/{id}")
	public String bloquear(@PathVariable("id") int idUser, RedirectAttributes attributes) {
		serviceUser.bloquear(idUser);
		
		attributes.addFlashAttribute("msg", "El usuario fue bloqueado y no tendra acceso al sistema");
		return "redirect:/user/index";
	}

}
