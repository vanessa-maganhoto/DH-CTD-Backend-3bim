package dao.impl;

import dao.IDao;
import dao.config.ConfigJDBC;
import model.Filial;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class FilialDaoH2 implements IDao<Filial> {

    private ConfigJDBC configJDBC;

    public FilialDaoH2(ConfigJDBC configJDBC) {
        this.configJDBC = configJDBC;
    }

    @Override
    public Filial salvar(Filial filial) {

        Connection connection = configJDBC.conectarComBancoDeDados();
        Statement stmt = null;
        String query = String.format(
                "INSERT INTO filial " +
                        "(nomeFilial, logradouro, numero, cidade, estado, e5Estrelas) " +
                        "VALUES ('%s', '%s', '%s', '%s', '%s', '%s')",
                filial.getNomeFilial(),
                filial.getLogradouro(),
                filial.getNumero(),
                filial.getCidade(),
                filial.getEstado(),
                filial.getE5Estrelas()
        );


        try {
            stmt = connection.createStatement();
            stmt.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);
            ResultSet keys = stmt.getGeneratedKeys();
            if (keys.next())
                filial.setId(keys.getInt(1));
            stmt.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return filial;
    }

    @Override
    public List<Filial> listar() {
        Connection connection = configJDBC.conectarComBancoDeDados();
        Statement stmt = null;
        String query =
                "select id, nomeFilial, logradouro, numero, cidade, estado, e5Estrelas from filial ";

        List<Filial> filiais = new ArrayList<>();

        try {
            stmt = connection.createStatement();
            stmt.execute(query);

            ResultSet resultSet = stmt.getResultSet();
            while (resultSet.next()) {
                Filial f = new Filial();
                f.setId(resultSet.getInt(1));
                f.setNomeFilial(resultSet.getString(2));
                f.setLogradouro(resultSet.getString(3));
                f.setNumero(resultSet.getString(4));
                f.setCidade(resultSet.getString(5));
                f.setEstado(resultSet.getString(6));
                f.setE5Estrelas(resultSet.getBoolean(7));

                filiais.add(f);
            }

            stmt.close();
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return filiais;
    }
}
