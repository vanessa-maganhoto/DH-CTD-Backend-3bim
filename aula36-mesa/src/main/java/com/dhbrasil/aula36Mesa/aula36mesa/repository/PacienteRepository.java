package com.dhbrasil.aula36Mesa.aula36mesa.repository;

import com.dhbrasil.aula36Mesa.aula36mesa.model.Dentista;
import com.dhbrasil.aula36Mesa.aula36mesa.model.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;


public interface PacienteRepository extends JpaRepository<Paciente, Integer> {
}
