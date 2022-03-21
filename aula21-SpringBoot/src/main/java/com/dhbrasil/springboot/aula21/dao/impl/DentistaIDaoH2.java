package com.dhbrasil.springboot.aula21.dao.impl;

import com.dhbrasil.springboot.aula21.dao.IDao;
import com.dhbrasil.springboot.aula21.dao.config.ConfigJDBC;
import com.dhbrasil.springboot.aula21.model.Dentista;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

@Repository
public class DentistaIDaoH2 implements IDao<Dentista> {

    private ConfigJDBC configJDBC;

    public DentistaIDaoH2(ConfigJDBC configJDBC) {
        this.configJDBC = configJDBC;
    }

    public Dentista salvar(Dentista dentista) {
        Connection connection = configJDBC.conectarComBancoDeDados();
        Statement stmt = null;
        String query = String.format(
                "INSERT INTO dentista " +
                        "(nome, sobrenome, matricula) " +
                        "VALUES ('%s', '%s', '%s')",
                dentista.getNome(),
                dentista.getSobrenome(),
                dentista.getMatricula()
        );

        try {
            stmt = connection.createStatement();
            stmt.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);
            ResultSet keys = stmt.getGeneratedKeys();
            if (keys.next())
                dentista.setId(keys.getInt(1));
            stmt.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return dentista;
    }


    /*@Override
    public List<Dentista> listar() {
        Connection connection = configJDBC.conectarComBancoDeDados();
        Statement stmt = null;
        String query =
                "select id, nome, sobrenome, matricula from dentista ";

        List<Dentista> dentistas = new ArrayList<>();

        try {
            stmt = connection.createStatement();
            stmt.execute(query);

            ResultSet resultSet = stmt.getResultSet();
            while (resultSet.next()) {
                Dentista d = new Dentista();
                d.setId(resultSet.getInt(1));
                d.setNome(resultSet.getString(2));
                d.setId(resultSet.getInt(3));

                dentistas.add(d);
            }

            stmt.close();
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }


        return dentistas;
    }*/
}



