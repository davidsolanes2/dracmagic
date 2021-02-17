package com.mersedes.dracmagicv3.security;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class DatabaseWebSecurity extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private DataSource dataSource;
	
	@Override
	protected void configure (AuthenticationManagerBuilder auth) throws Exception {
		auth.jdbcAuthentication().dataSource(dataSource)
		.usersByUsernameQuery("select email, password, estatus from User where email=?")
		.authoritiesByUsernameQuery("select u.email, r.name from users_roles ur " +
				"inner join User u on u.id = ur.user_id " + 
				"inner join Role r on r.id = ur.role_id " + 
				"where u.email = ?");
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http.authorizeRequests()
		// static resources
		
		// public views that do not require authentication
			//static resources
			.antMatchers(
					"/assets",
					"/bootstrap/css",
					"/bootstrap/js"
				).permitAll()
			//public views
			.antMatchers(
					"/",
					"/modals/login",
					"/modals/register",
					"/layouts/principal"
				).permitAll()
			.antMatchers("/user/**"
					).hasAnyAuthority("USUARIO")

		// public views that require authentication
			//.anyRequest().authenticated();
		// login form without authentication
		//	.and().formLogin().loginPage("/modals/login").permitAll();
		.and()
		.formLogin()
		.loginPage("/modals/login").permitAll()
		.defaultSuccessUrl("/layouts/principal", true);
		
		
	}
	
	/**
	 *  Implementación de Spring Security que encripta passwords con el algoritmo Bcrypt
	 * @return
	 */
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

}
