package dao.impl;


import com.dhbrasil.springboot.aula21.model.Endereco;
import dao.IDao;
import dao.config.ConfiguracaoJDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EnderecoDaoH2 implements IDao<Endereco> {

    private ConfiguracaoJDBC configuracaoJDBC;

    public EnderecoDaoH2() {
        this.configuracaoJDBC = new ConfiguracaoJDBC();
    }
    // Salvar
    @Override
    public Endereco salvar(Endereco endereco){
        Connection conexao = configuracaoJDBC.conectarComBancoDeDados();
        PreparedStatement pstmt = null;

        String query = String.format("INSERT INTO enderecos" +
                "(rua, numero, bairro, cidade, estado) " +
                "VALUES ('%s', '%s', '%s', '%s', '%s') ",
                endereco.getNumero(),
                endereco.getNumero(),
                endereco.getBairro(),
                endereco.getCidade(),
                endereco.getEstado());

        try {
            pstmt = conexao.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);
            pstmt.executeUpdate();
            ResultSet keys = pstmt.getGeneratedKeys();
            if (keys.next())
                endereco.setId(keys.getInt(1));
            pstmt.close();
            conexao.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return endereco;
    }

    // Buscar por ID

    // Buscar todos os registros
    @Override
    public List<Endereco> buscarTodos(){
        Connection connection = configuracaoJDBC.conectarComBancoDeDados();
        PreparedStatement pstmt = null;

        String query = "SELECT * FROM enderecos";
        List<Endereco> enderecos = new ArrayList<>();

        try{
            pstmt = connection.prepareStatement(query);
            ResultSet result = pstmt.executeQuery();

            while(result.next()){
                enderecos.add(criarObjetoEndereco(result));
            }
            pstmt.close();
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return enderecos;
    }

    // Atualizar

    // Excluir

    private Endereco criarObjetoEndereco(ResultSet result) throws SQLException{
        return new Endereco(
                result.getInt("id"),
                result.getString("rua"),
                result.getString("numero"),
                result.getString("bairro"),
                result.getString("cidade"),
                result.getString("estado"));


    }

}
