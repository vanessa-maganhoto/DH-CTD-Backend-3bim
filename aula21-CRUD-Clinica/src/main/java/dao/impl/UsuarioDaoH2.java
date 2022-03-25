package dao.impl;

import com.dhbrasil.springboot.aula21.model.Dentista;
import com.dhbrasil.springboot.aula21.model.Usuario;
import dao.IDao;
import dao.config.ConfiguracaoJDBC;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UsuarioDaoH2 implements IDao<Usuario> {

    private ConfiguracaoJDBC configuracaoJDBC;

    public UsuarioDaoH2() {
        this.configuracaoJDBC = new ConfiguracaoJDBC();
    }

    //Salvar
    @Override
    public Usuario salvar(Usuario usuario) {
        Connection conexao = configuracaoJDBC.conectarComBancoDeDados();
        PreparedStatement pstmt = null;

        String query = String.format("INSERT INTO usuarios " +
                        "(nome ,email, senha, acesso) " +
                        "VALUES ('%s','%s','%s','%s')",
                usuario.getNome(),
                usuario.getEmail(),
                usuario.getSenha(),
                usuario.getAcesso());

        try {
            pstmt = conexao.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);
            pstmt.executeUpdate();
            ResultSet keys = pstmt.getGeneratedKeys();
            if (keys.next())
                usuario.setId(keys.getInt(1));
            pstmt.close();
            conexao.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return usuario;
    }


    // Buscar por ID
    @Override
    public Optional<Usuario> buscar(Integer id) {
        Connection conexao = configuracaoJDBC.conectarComBancoDeDados();
        Statement stmt = null;
        String query = String.format(
                "SELECT id, nome, email, senha, acesso " +
                        "FROM usuarios WHERE id= '%s'", id);
        Usuario usuario = null;

        try{
            stmt = conexao.createStatement();
            ResultSet resultado = stmt.executeQuery(query);
            while(resultado.next()){
                usuario = criarObjetoUsuario(resultado);
            }
            stmt.close();
            conexao.close();

        } catch (SQLException e){
            e.printStackTrace();
        }
        return usuario != null ? Optional.of(usuario) : Optional.empty();
    }

    // Buscar todos os registros
    @Override
    public List<Usuario> buscarTodos(){
        Connection connection = configuracaoJDBC.conectarComBancoDeDados();
        PreparedStatement pstmt = null;

        String query = "SELECT * FROM usuarios";
        List<Usuario> usuarios = new ArrayList<>();

        try{
            pstmt = connection.prepareStatement(query);
            ResultSet result = pstmt.executeQuery();

            while(result.next()){
                usuarios.add(criarObjetoUsuario(result));
            }
            pstmt.close();
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return usuarios;
    }



    //Atualizar
    @Override
    public Usuario atualizar(Usuario usuario) {
        Connection conexao = configuracaoJDBC.conectarComBancoDeDados();
        String query = String.format(
                "UPDATE usuarios SET nome = '%s', email = '%s', " +
                        "senha = '%s', acesso = '%s' " +
                        "WHERE id = '%s' ",
                usuario.getNome(),
                usuario.getEmail(),
                usuario.getSenha(),
                usuario.getAcesso(),
                usuario.getId());

        execute(conexao, query);
        return usuario;
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
        String query = String.format("DELETE FROM usuarios WHERE id = '%s'", id);
        try{
            stmt = conexao.createStatement();
            stmt.executeUpdate(query);
            stmt.close();
            conexao.close();
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private Usuario criarObjetoUsuario(ResultSet result) throws SQLException{
        return new Usuario(
                result.getInt("id"),
                result.getString("nome"),
                result.getString("email"),
                result.getString("senha"),
                result.getInt("acesso"));

    }

}
