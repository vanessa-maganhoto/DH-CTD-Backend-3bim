package com.dhbrasil.aula36Mesa.aula36mesa.repository;

import com.dhbrasil.aula36Mesa.aula36mesa.model.Dentista;
import org.springframework.data.jpa.repository.JpaRepository;


public interface DentistaRepository extends JpaRepository<Dentista, Integer> {
}
