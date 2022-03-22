package dao.impl;

import com.dhbrasil.springboot.aula21.model.Dentista;
import com.dhbrasil.springboot.aula21.model.Usuario;
import dao.IDao;
import dao.config.ConfiguracaoJDBC;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

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
                usuarios.add(criarObjetoDentista(result));
            }
            pstmt.close();
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return usuarios;
    }

    //Atualizar

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

    private Usuario criarObjetoDentista(ResultSet result) throws SQLException{
        return new Usuario(
                result.getInt("id"),
                result.getString("nome"),
                result.getString("email"),
                result.getString("senha"),
                result.getInt("acesso"));

    }

}
