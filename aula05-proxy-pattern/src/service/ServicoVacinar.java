package service;

import java.util.Date;

public class ServicoVacinar implements Vacinar{


    @Override
    public void vacinarPessoa(String rg, Date dataVacina, String tipoVacina) {
        System.out.println("Pessoa portadora do rg: " + rg+ " foi vacinada em " + dataVacina +" com sucesso.");
    }
}
