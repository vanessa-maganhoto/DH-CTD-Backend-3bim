package test;

import dao.config.ConfigJDBC;
import dao.impl.EnderecoDaoH2;
import model.Endereco;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import service.EnderecoService;

class EnderecoServiceTest {

    private static final Logger LOGGER = Logger.getLogger(EnderecoServiceTest.class);

    private EnderecoService enderecoService = new EnderecoService(
            new EnderecoDaoH2(
                    new ConfigJDBC()));

    @BeforeAll
    static void ConfigLog() {
        BasicConfigurator.configure();
    }

    @Test
    public void cadastrarEnderecoNoH2() {
        LOGGER.info("Cadastrando o endereço no H2...");
        Endereco endereco1 = enderecoService.salvar(new Endereco(
                "Av. Eldorado", "2154",
                "São Paulo", "Morumbi"));
    }
}