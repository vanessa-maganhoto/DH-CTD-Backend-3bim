package model;

import org.junit.jupiter.api.Test;
import service.ServicoVacinarProxy;
import service.Vacinar;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class PessoaTest {

        Date dataVac = new Date();

        @Test
        public void vac(){
            Pessoa p1 = new Pessoa("Amadeu", "Pereira", "11223344", dataVac, "Pfizer");
            Vacinar vacinar = new ServicoVacinarProxy();
            vacinar.vacinarPessoa(p1.getRg(), p1.getDataVacina(), p1.getNomeVacina());
            System.out.println(p1.toString());
        }




}