package com.dhbrasil.springboot.aula21;

import com.dhbrasil.springboot.aula21.model.Dentista;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class Aula21Application {

	public static void main(String[] args) {

		SpringApplication.run(Aula21Application.class, args);


	}

	@GetMapping
	public String Ola() {
		Dentista dentista = new Dentista(2, "laio", "mendes", 521513);
		return dentista.toString() ;
	}

}
