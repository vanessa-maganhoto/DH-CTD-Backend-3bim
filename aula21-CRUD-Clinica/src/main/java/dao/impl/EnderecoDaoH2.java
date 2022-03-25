package dao.impl;


import com.dhbrasil.springboot.aula21.model.Dentista;
import com.dhbrasil.springboot.aula21.model.Endereco;
import dao.IDao;
import dao.config.ConfiguracaoJDBC;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
    @Override
    public Optional<Endereco> buscar(Integer id){
        Connection conexao = configuracaoJDBC.conectarComBancoDeDados();
        Statement stmt = null;
        String query = String.format(
                "SELECT id, rua, numero, bairro, cidade, estado " +
                        "FROM enderecos WHERE id= '%s'", id);
        Endereco endereco = null;

        try{
            stmt = conexao.createStatement();
            ResultSet resultado = stmt.executeQuery(query);
            while(resultado.next()){
                endereco = criarObjetoEndereco(resultado);
            }
            stmt.close();
            conexao.close();

        } catch (SQLException e){
            e.printStackTrace();
        }
        return endereco != null ? Optional.of(endereco) : Optional.empty();
    }
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
    @Override
    public Endereco atualizar(Endereco endereco){
        Connection conexao = configuracaoJDBC.conectarComBancoDeDados();
        String query = String.format(
                "UPDATE enderecos SET rua = '%s', numero = '%s', " +
                        "bairro = '%s', cidade = '%s' " +
                        "estado = '%s' " +
                        "WHERE id = '%s' ",
                endereco.getRua(),
                endereco.getNumero(),
                endereco.getBairro(),
                endereco.getCidade(),
                endereco.getEstado(),
                endereco.getId());

        execute(conexao, query);
        return endereco;
    }

    private void execute(Connection conexao, String query) {
        try{
            PreparedStatement pstm = null;
            pstm = conexao.prepareStatement(query);
            pstm.executeUpdate();
            conexao.close();
            pstm.close();
        } catch (SQLException e){
            e.printStackTrace();
        }


    }

    // Excluir

    @Override
    public void excluir(Integer id){
        Connection conexao = configuracaoJDBC.conectarComBancoDeDados();
        Statement stmt = null;
        String query = String.format("DELETE FROM enderecos WHERE id = '%s'", id);
        try{
            stmt = conexao.createStatement();
            stmt.executeUpdate(query);
            stmt.close();
            conexao.close();
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }

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
