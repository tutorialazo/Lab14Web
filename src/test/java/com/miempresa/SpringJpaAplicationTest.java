package com.miempresa;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.miempresa.model.Usuario;
import com.miempresa.repository.IUsuario;

@SpringBootTest
public class SpringJpaAplicationTest {
	
	@Autowired
	private IUsuario repo;
	
	@Bean
	public BCryptPasswordEncoder passEncoder() {
		BCryptPasswordEncoder bcpe = new BCryptPasswordEncoder();
		return bcpe;
	}
	
	@Autowired
	private BCryptPasswordEncoder encoder;
	
		
	@Test
	void crearUsuario() {
		Usuario user = new Usuario();
		user.setId(2);
		user.setNombre("usuario2");
		user.setClave(encoder.encode("1234"));
		user.setRol("ROLE_USER");
		repo.save(user);
	}
}
