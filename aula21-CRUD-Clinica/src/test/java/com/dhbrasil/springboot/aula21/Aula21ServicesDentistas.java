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

@SpringBootTest
class Aula21ServicesDentistas {

	private static DentistaService dentistaService = new DentistaService(new DentistaDaoH2());
	private static UsuarioService usuarioService = new UsuarioService(new UsuarioDaoH2());

	@Test
	void contextLoads() {
	}


	@Disabled
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
	@Disabled
	@Test
	public void excluirDentistaComId2(){
		dentistaService.excluir(2);
	}

	@Disabled
	@Test
	public void trazerTodosOsDentistas(){
		List<Dentista> dentistaList = dentistaService.buscarTodos();
		System.out.println(dentistaList);
	}

	@Test
	public void inserirTresUsuarios(){
		Usuario u1 = new Usuario(
				"Patricia", "patricia@gmail.com", "pati123", 0
		);

		Usuario u2 = new Usuario(
				"Maria", "maria@gmail.com", "maria123", 1
		);

		Usuario u3 = new Usuario(
				"Ana", "ana@gmail.com", "ana222", 0
		);

		usuarioService.salvar(u1);
		usuarioService.salvar(u2);
		usuarioService.salvar(u3);

	}

	@Test
	public void trazerTodosOsUsuarios(){
		List<Usuario> usuarioListList = usuarioService.buscarTodos();
		System.out.println(usuarioListList);
	}

	@Test
	public void excluirUsuarioComId2(){
		usuarioService.excluir(2);
	}

}
