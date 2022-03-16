package service;

import model.Conta;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import java.sql.*;

public class ContaService {

    private static final Logger LOGGER = Logger.getLogger(ContaService.class);
    private static final String SQL_CREATE_TABLE = "DROP TABLE IF EXISTS conta; "
            + " CREATE TABLE conta"
            + " (id int PRIMARY KEY,"
            + " nome VARCHAR(64) NOT NULL,"
            + " numConta VARCHAR(64) NOT NULL, "
            + " saldoAtual double);";

    private static final String SQL_INSERT = "INSERT INTO conta "
            + "(id, nome, numConta, saldoAtual) "
            + "VALUES (?, ?, ?, ?);";

    private static final String SQL_UPDATE = "UPDATE conta SET saldoAtual = ? WHERE id = ?";

    public static void main(String[] args) throws Exception{
        BasicConfigurator.configure();

        Conta c1 = new Conta (1, "Bill", "5522-5", 0.0);

        Connection connection = null;

        try{
            connection = getConnection();
            Statement statement = connection.createStatement();
            LOGGER.info("Criando a tabela conta.");
            statement.execute(SQL_CREATE_TABLE);

            PreparedStatement inserir = connection.prepareStatement(SQL_INSERT);
            inserir.setInt(1, 1);
            inserir.setString(2, c1.getNome());
            inserir.setString(3, c1.getNumConta());
            inserir.setDouble(4, c1.getSaldo());
            LOGGER.info("Inserindo o Bill no BD");
            inserir.execute();

            mostrarDadosDaConta(connection);

            PreparedStatement atualizarConta = connection.prepareStatement(SQL_UPDATE);
            atualizarConta.setDouble(1, 10.00);
            atualizarConta.setInt(2, 1);
            LOGGER.info("Depositando R$10.00");
            atualizarConta.execute();

            mostrarDadosDaConta(connection);
            PreparedStatement atualizarConta2 = connection.prepareStatement(SQL_UPDATE);
            atualizarConta2.setDouble(1, 15.00 + mostrarSaldo(connection));
            atualizarConta2.setInt(2, 1);
            LOGGER.info("Depositando R$15.00");
            atualizarConta2.execute();

            LOGGER.info("Saldo atual: " + mostrarSaldo(connection));
        }
        catch (Exception e){
            LOGGER.error("Erro de acesso ao BD " + e);
        }
        finally {
            if(connection == null){
                return;
            }
            connection.close();
        }
    }

    public static Connection getConnection() throws Exception {
        Class.forName("org.h2.Driver");
        return DriverManager.getConnection("jdbc:h2:mem:aula13", "sa", "");
    }

    public static void mostrarDadosDaConta(Connection connection) throws Exception{
        String sqlSelect = "SELECT * FROM conta;";
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery(sqlSelect);
        LOGGER.info("Dados das contas: ");
        while(rs.next()){
            System.out.println("ID: " + rs.getInt(1)
                    + " Nome: " + rs.getString(2)
                    + " Conta: " + rs.getString(3)
                    + " Saldo: " + rs.getDouble(4));
        }
    }

    public static double mostrarSaldo(Connection connection) throws Exception{
        // Select para buscar ao saldo
        String sqlSelectSaldo = "SELECT saldoAtual FROM conta WHERE id = 1";
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery(sqlSelectSaldo);
        rs.next();
        double resp = rs.getDouble(1);
        return resp;
        //PreparedStatement atualizarSaldo = connection.prepareStatement(sqlSelectSaldo);

    }
}
