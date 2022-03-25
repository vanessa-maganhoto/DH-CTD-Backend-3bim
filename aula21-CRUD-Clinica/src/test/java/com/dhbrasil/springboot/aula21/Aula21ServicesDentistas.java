package com.dhbrasil.springboot.aula21;

import com.dhbrasil.springboot.aula21.model.Dentista;
import com.dhbrasil.springboot.aula21.model.Usuario;
import com.dhbrasil.springboot.aula21.service.DentistaService;
import com.dhbrasil.springboot.aula21.service.UsuarioService;
import dao.impl.DentistaDaoH2;
import dao.impl.UsuarioDaoH2;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

@SpringBootTest
class Aula21ServicesDentistas {

	private static DentistaService dentistaService = new DentistaService(
			new DentistaDaoH2());

	@Test
	void contextLoads() {
	}

	@Disabled
	@Test
	public void carregarTresDentistas() {
		Dentista d1 = new Dentista(
				"Pedro", "pramos@gmail.com", 21547, 0);
		Dentista d2 = new Dentista(
				"Marta", "msilveira@outlook.com", 12539, 1);
		Dentista d3 = new Dentista(
				"Marcia", "marcia.soares@hotmail.com", 44127, 1);

		dentistaService.salvar(d1);
		dentistaService.salvar(d2);
		dentistaService.salvar(d3);
	}

	@Disabled
	@Test
	public void excluirDentistaComId2() {
		dentistaService.excluir(2);
	}

	@Disabled
	@Test
	public void buscarDentistaPorId1() {
		Optional<Dentista> d = dentistaService.buscar(1);
		System.out.println(d);
	}

	@Disabled
	@Test
	public void atualizarDentistaComId3() {
		Dentista dentAt = new Dentista(
				3, "Marcia Dantas Moraes",
				"dentista@dantas.com.br",
				44127, 0);
		Dentista dentUp = dentistaService.atualizar(dentAt);
		System.out.println(dentUp);
	}

	@Disabled
	@Test
	public void trazerTodosOsDentistas() {
		List<Dentista> dentistasList = dentistaService.buscarTodos();
		System.out.println(dentistasList);
	}

}

