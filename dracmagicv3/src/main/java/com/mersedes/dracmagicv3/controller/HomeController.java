package com.mersedes.dracmagicv3.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.mersedes.dracmagicv3.model.Role;
import com.mersedes.dracmagicv3.model.User;
import com.mersedes.dracmagicv3.services.UserService;

@Controller
@RequestMapping("/")
public class HomeController {
	
	@Autowired
	private UserService serviceUser;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@GetMapping
	public String main(Model model) {
		return "home";
	}
	
	@GetMapping("/principal")
	public String mostrarPrincipal() {
		return "layouts/principal";
	}

	/**
	 * Metodo que mapea el boton Login
	 * @param authentication
	 * @param session
	 * @return
	 * */
	 @GetMapping("/index")
	 public String mostrarPrincipal(Authentication auth, HttpSession session) {
	  		String firstName = auth.getName();
	  			for(GrantedAuthority rol: auth.getAuthorities()) {
	   			System.out.println("ROL: " + rol.getAuthority()); }
	   		if (session.getAttribute("user") == null) {
	   	 		User user = serviceUser.buscarPorFirstName(firstName);
	  				session.setAttribute("user", user); }
	   return "redirect:/principal"; }
	
	
	/*
	 * Metodo que muestra el formulario para que se registren nuevos usuarios
	 * @param user
	 * @return
	 * */
	/*
	 * @GetMapping("/register") public String registerUser(User user) { return
	 * "/register"; }
	 */
	
	/*
	 * Metodo que guarda en la bd el usuario registrado
	 * @param user
	 * @param attributes
	 * @return
	 * */
	@PostMapping("/registration")
	public String registerUser(User user, RedirectAttributes attributes) {
		
		//recuperamos el password
		String pwdPlano = user.getPassword();
		//encriptamos
		String pwdEncriptado = passwordEncoder.encode(pwdPlano);
		//hacemos un set
		user.setPassword(pwdEncriptado);
		user.setEstatus(1);
		user.setFechaRegistro(new Date());
		
		Role role = new Role();
		role.setId(3);
		user.agregar(role);
		
		serviceUser.guardar(user);
		
		attributes.addFlashAttribute("msg", "Has sido registrado");
		
		return "/registration";
	}
	
//	/*
//	 * Metodo que muestra el formulario de login personalizado
//	 * @return
//	 * */
//	@GetMapping("/modal_login")
//	public String mostrarLogin() {
//		return "modal_login";
//	}
	
//	@RequestMapping("/modal_login")
//	public ModelAndView getValidaLogin( HttpServletRequest req, HttpServletResponse resp) {
//		ModelAndView modelo = new ModelAndView();
//		String email = req.getParameter("email");
//		String password = req.getParameter("password");
//		if(email.equals("davidsolanes2@gmail.com") && password.equals("d4v1d001")) {
//			modelo.setViewName("principal");
//		} /*
//			 * else { modelo.setViewName( <div th:if="${param.error}"> <div
//			 * class="alert alert-danger">Invalid username or password.</div> </div> );
//			 *
//			}*/
//		
//		return modelo;
//	}
//	
	
	/*
	 * Metodo personalizado para cerrar la sesion del usuario
	 * @param request
	 * @return
	 * */
	@GetMapping("/logout")
	public String logout(HttpServletRequest request) {
		SecurityContextLogoutHandler logoutHandler = new SecurityContextLogoutHandler();
		logoutHandler.logout(request, null, null);
		return "redirect:/";
	}
	
	
}
