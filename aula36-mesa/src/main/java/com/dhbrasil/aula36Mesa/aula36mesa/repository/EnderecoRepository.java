package com.dhbrasil.aula36Mesa.aula36mesa.repository;

import com.dhbrasil.aula36Mesa.aula36mesa.model.Dentista;
import com.dhbrasil.aula36Mesa.aula36mesa.model.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;


public interface EnderecoRepository extends JpaRepository<Endereco, Integer> {
}
