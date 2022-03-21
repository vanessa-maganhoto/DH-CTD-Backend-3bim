package com.dhbrasil.springboot.aula21;

import com.dhbrasil.springboot.aula21.model.Dentista;
import com.dhbrasil.springboot.aula21.service.DentistaService;
import dao.impl.DentistaDaoH2;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class Aula21ServicesDentistas {

	private static DentistaService dentistaService = new DentistaService(new DentistaDaoH2());

	@Test
	void contextLoads() {
	}

	@Test
	public void carregarTresDentistas(){
		Dentista d1 = new Dentista(
				"Pedro", "pramos@gmail.com", 21547, 0
		);

		Dentista d2 = new Dentista(
				"Marcia", "marcia@gmail.com", 12539, 1
		);

		Dentista d3 = new Dentista(
				"Antonela", "antonela@gmail.com", 44127, 1
		);

		dentistaService.salvar(d1);
		dentistaService.salvar(d2);
		dentistaService.salvar(d3);
	}

	@Test
	public void trazerTodosOsDentistas(){
		List<Dentista> dentistaList = dentistaService.buscarTodos();
		System.out.println(dentistaList);
	}
}
