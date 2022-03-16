package dao.impl;

import dao.ConfigJDBC;
import dao.IDao;
import model.Medicamento;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MedicamentoDaoH2 implements IDao<Medicamento> {

    private ConfigJDBC configJDBC;

    public MedicamentoDaoH2(ConfigJDBC configJDBC) {
        this.configJDBC = configJDBC;
    }

    @Override
    public Medicamento salvar (Medicamento medicamento){
        Connection connection = configJDBC.conectarComBD();
        Statement statement = null;

        String query = String.format(
                "INSERT INTO medicamentos " +
                        "(nome, laboratorio, quantidade, preco) " +
                        "VALUES ('%s', '%s', '%s', '%s')",
                        medicamento.getNome(),
                        medicamento.getLaboratorio(),
                        medicamento.getQuantidade(),
                        medicamento.getPreco());


        try{
            statement = connection.createStatement();
            statement.execute(query, Statement.RETURN_GENERATED_KEYS);
            ResultSet keys = statement.getGeneratedKeys();
            if(keys.next())
                medicamento.setId(keys.getInt(1));
            statement.close();
            connection.close();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return medicamento;
    }


}
