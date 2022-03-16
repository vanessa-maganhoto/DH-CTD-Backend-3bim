package service;

import dao.IDao;
import model.Filial;
import org.apache.log4j.Logger;

import java.util.List;

public class FilialService {

    private static final Logger LOGGER = Logger.getLogger(FilialService.class);

    private IDao<Filial> filialIDao;

    public FilialService(IDao<Filial> filialIDao) {

        this.filialIDao = filialIDao;
    }

    public Filial salvar(Filial filial) {
        LOGGER.info(String.format("Salvando filial... [%s]", filial));
        Filial salvar = filialIDao.salvar(filial);
        LOGGER.info(String.format("Filial salva com o id: [%s]", filial.getId()));

        return salvar;
    }

    public List<Filial> listar() {
        LOGGER.info("Listando filiais...");
        List<Filial> filiais = filialIDao.listar();
        LOGGER.info(String.format("Foram encontras [%s] filiais", filiais.size()));

        return filiais;
    }
}
