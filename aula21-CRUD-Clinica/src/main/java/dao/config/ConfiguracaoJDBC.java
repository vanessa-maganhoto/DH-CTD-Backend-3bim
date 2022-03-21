package dao.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConfiguracaoJDBC {

    private String jdbcDriver;
    private String dbUrl;
    private String nomeUsuario;
    private String senhaUsuario;

    public ConfiguracaoJDBC() {
        this.jdbcDriver = "com.mysql.cj.jdbc.Driver";
        this.dbUrl = "jdbc:mysql://localhost:3306/clinica";
        this.nomeUsuario = "root";
        this.senhaUsuario = "root";
    }

    public Connection conectarComBancoDeDados() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(
                    dbUrl, nomeUsuario, senhaUsuario);
            System.out.println(
                    "Conexão com o Banco de Dados efetuada com sucesso!");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return connection;
    }

}