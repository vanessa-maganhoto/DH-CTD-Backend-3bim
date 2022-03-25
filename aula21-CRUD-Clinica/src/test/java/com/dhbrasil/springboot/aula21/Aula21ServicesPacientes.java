package com.dhbrasil.springboot.aula21;

import com.dhbrasil.springboot.aula21.model.Endereco;
import com.dhbrasil.springboot.aula21.model.Paciente;
import com.dhbrasil.springboot.aula21.service.PacienteService;
import dao.impl.EnderecoDaoH2;
import dao.impl.PacienteDaoH2;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.List;
import java.util.Optional;


@SpringBootTest
    class Aula21ServicesPacientes {

        private static PacienteService pacienteService = new PacienteService(
                new PacienteDaoH2(
                        new EnderecoDaoH2()));

        @Test
        void contextLoads() {
        }

        @Disabled
        @Test
        public void carregarTresPacientes() {

            Endereco e1 = new Endereco(
                    "Av. Eldorado", "445", "Centro",
                    "São Paulo", "SP"
            );

            Paciente p1 = new Paciente("Carlos", "Moraes",
                    "12365498785", new Date(), e1);

            Endereco e2 = new Endereco(
                    "Av. Bento Gonçalves", "25", "Centro",
                    "Porto Alegre", "RS"
            );

            Paciente p2 = new Paciente("Antonio", "Magalhães",
                    "22225410005", new Date(), e2);

            Endereco e3 = new Endereco(
                    "Gomes Jardim", "1254", "Santana",
                    "Porto Alegre", "RS"
            );

            Paciente p3 = new Paciente("Marcelo", "Souza",
                    "95223336522", new Date(), e3);

            pacienteService.salvar(p1);
            pacienteService.salvar(p2);
            pacienteService.salvar(p3);
        }

        @Disabled
        @Test
        public void buscarPeloId3() {
            Optional<Paciente> pac = pacienteService.buscar(3);
            System.out.println(pac);
        }

        @Disabled
        @Test
        public void excluirPeloId3() {
            pacienteService.excluir(3);
        }

        @Disabled
        @Test
        public void BuscarTodosOsPacientes() {
            List<Paciente> pacienteList = pacienteService.buscarTodos();
            System.out.println(pacienteList);
        }

        //@Disabled
        @Test
        public void atualizarPacienteComId4() {

            Endereco endAt = new Endereco(
                    6, "Av. Paraguassú", "541", "Centro",
                    "Capão da canoa", "RS");

            Paciente pacRec = new Paciente(
                    4, "Marcelo", "Gonçalves de Souza",
                    "21447888888", endAt);


            pacienteService.atualizar(pacRec);
        }
}

