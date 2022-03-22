package dao.impl;

import com.dhbrasil.springboot.aula21.model.Dentista;
import dao.IDao;
import dao.config.ConfiguracaoJDBC;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DentistaDaoH2 implements IDao<Dentista> {

    private ConfiguracaoJDBC configuracaoJDBC;

    public DentistaDaoH2() {

        this.configuracaoJDBC = new ConfiguracaoJDBC();
    }

    // CRUD

    // Salvar
    @Override
    public Dentista salvar(Dentista dentista) {
        Connection conexao = configuracaoJDBC.conectarComBancoDeDados();
        PreparedStatement pstmt = null;

        String query = String.format("INSERT INTO dentistas " +
                        "(nome ,email, numMatricula, atendeConvenio) " +
                        "VALUES ('%s','%s','%s','%s')",
                dentista.getNome(),
                dentista.getEmail(),
                dentista.getNumMatricula(),
                dentista.getAtendeConvenio());

        try {
            pstmt = conexao.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);
            pstmt.executeUpdate();
            ResultSet keys = pstmt.getGeneratedKeys();
            if (keys.next())
                dentista.setId(keys.getInt(1));
            pstmt.close();
            conexao.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dentista;
    }

    // Buscar por ID

    // Buscar todos os registros
    @Override
    public List<Dentista> buscarTodos(){
        Connection connection = configuracaoJDBC.conectarComBancoDeDados();
        PreparedStatement pstmt = null;

        String query = "SELECT * FROM dentistas";
        List<Dentista> dentistas = new ArrayList<>();

        try{
            pstmt = connection.prepareStatement(query);
            ResultSet result = pstmt.executeQuery();

            while(result.next()){
                dentistas.add(criarObjetoDentista(result));
            }
            pstmt.close();
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return dentistas;
    }


    // Atualizar

    // Excluir
    @Override
    public void excluir(Integer id){
        Connection conexao = configuracaoJDBC.conectarComBancoDeDados();
        Statement stmt = null;
        String query = String.format("DELETE FROM dentistas WHERE id = '%s'", id);
        try{
            stmt = conexao.createStatement();
            stmt.executeUpdate(query);
            stmt.close();
            conexao.close();
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private Dentista criarObjetoDentista(ResultSet result) throws SQLException{
        return new Dentista(
                result.getInt("id"),
                result.getString("nome"),
                result.getString("email"),
                result.getInt("numMatricula"),
                result.getInt("atendeConvenio"));

    }

}
