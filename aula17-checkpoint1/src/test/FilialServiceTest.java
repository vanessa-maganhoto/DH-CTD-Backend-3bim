package test;

import dao.config.ConfigJDBC;
import dao.impl.FilialDaoH2;
import model.Filial;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import service.FilialService;

import java.util.List;

public class FilialServiceTest {

    private static final Logger LOGGER = Logger.getLogger(FilialServiceTest.class);

    private FilialService filialService = new FilialService(
            new FilialDaoH2(
                    new ConfigJDBC()));

    @BeforeAll
    static void ConfigLog() {
        BasicConfigurator.configure();
    }

    @Test
    public void salvarFilialH2() {
        LOGGER.info("Cadastro de filial no banco de dados H2...");
        Filial filial;
        Filial filialCentro;

        filial = new Filial("Centro", "Avenida São João", "439", "São Paulo", "SP", true);
        filialCentro = filialService.salvar(filial);

        filial = new Filial("Leste", "Rua Adelaide de Freitas", "36", "São Paulo", "SP", false);
        filialCentro = filialService.salvar(filial);

        filial = new Filial("Sul", "Rua Afonso Celso", "235", "São Paulo", "SP", false);
        filialCentro = filialService.salvar(filial);

        filial = new Filial("Norte-Santana", "Avenida João Marcelino Branco", "78",  "São Paulo", "SP", true);
        filialCentro = filialService.salvar(filial);

        filial = new Filial("Oeste-Freguesia", "Rua Almo Abrahão Bertazzo", "154",  "São Paulo", "SP", true);
        filialCentro = filialService.salvar(filial);


        List<Filial> filiais = filialService.listar();
        for (Filial f : filiais) {
            LOGGER.info(f);
        }

    }
}
