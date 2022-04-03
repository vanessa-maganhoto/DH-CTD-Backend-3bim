package resources.impl;

import com.dhbrasil.springboot.aula21.model.*;
import com.dhbrasil.springboot.aula21.util.Util;
import resources.IDao;
import resources.config.ConfiguracaoJDBC;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ConsultaDaoH2 implements IDao<Consulta> {

    private ConfiguracaoJDBC configuracaoJDBC;
    private DentistaDaoH2 dentistaDaoH2;
    private PacienteDaoH2 pacienteDaoH2;
    private UsuarioDaoH2 usuarioDaoH2;

    public ConsultaDaoH2(DentistaDaoH2 dentistaDaoH2, PacienteDaoH2 pacienteDaoH2, UsuarioDaoH2 usuarioDaoH2) {
        this.dentistaDaoH2 = dentistaDaoH2;
        this.pacienteDaoH2 = pacienteDaoH2;
        this.usuarioDaoH2 = usuarioDaoH2;

        this.configuracaoJDBC = new ConfiguracaoJDBC();
    }


    @Override
    public Consulta salvar(Consulta consulta) {
        Connection conexao = configuracaoJDBC.conectarComBancoDeDados();
        PreparedStatement pstmt = null;

//        consulta.setDentista(dentistaDaoH2.salvar(consulta.getDentista()));
//        consulta.setPaciente(pacienteDaoH2.salvar(consulta.getPaciente()));
//        consulta.setUsuario(usuarioDaoH2.salvar(consulta.getUsuario()));

        String query = String.format("INSERT INTO consultas " +
                "(id_paciente, id_dentista, id_usuario, dataCad, dataAtend) " +
                "VALUES ('%s','%s','%s','%s','%s')",
        consulta.getPaciente().getId(),
        consulta.getDentista().getId(),
        consulta.getUsuario().getId(),
                Util.dateToTimestamp(consulta.getDataCad()),
                Util.dateToTimestamp(consulta.getDataAtend()));

        try{
            pstmt = conexao.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);
            pstmt.executeUpdate();
            ResultSet keys = pstmt.getGeneratedKeys();
            if (keys.next())
                consulta.setId(keys.getInt(1));
            pstmt.close();
            conexao.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return consulta;

    }

    @Override
    public Optional<Consulta> buscar(Integer id) {
        Connection conexao = configuracaoJDBC.conectarComBancoDeDados();
        Statement stmt = null;
        String query = String.format(
                "SELECT id, id_paciente, id_dentista, id_usuario, dataCad, dataAtend " +
                        "FROM consultas WHERE id = '%s'", id);
        Consulta consulta = null;
        try {
            stmt = conexao.createStatement();
            ResultSet resultado = stmt.executeQuery(query);
            while (resultado.next()) {
                consulta = criarObjetoConsulta(resultado);
            }
            stmt.close();
            conexao.close();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }

        return consulta != null ? Optional.of(consulta) : Optional.empty();

    }

    @Override
    public void excluir(Integer id) {
        Connection conexao = configuracaoJDBC.conectarComBancoDeDados();
        Statement stmt = null;
        String query = String.format(
                "DELETE FROM consultas WHERE id = '%s'", id);
        try {
            stmt = conexao.createStatement();
            stmt.executeUpdate(query);
            stmt.close();
            conexao.close();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Consulta> buscarTodos() {
        Connection conexao = configuracaoJDBC.conectarComBancoDeDados();
        PreparedStatement pstmt = null;
        String query = "SELECT * FROM consultas;";

        List<Consulta> consultas = new ArrayList<>();
        try {
            pstmt = conexao.prepareStatement(query);
            ResultSet resultado = pstmt.executeQuery();
            while (resultado.next()) {
                consultas.add(criarObjetoConsulta(resultado));
            }
            pstmt.close();
            conexao.close();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }

        return consultas;
    }

    @Override
    public Consulta atualizar(Consulta consulta) {
        Connection conexao = configuracaoJDBC.conectarComBancoDeDados();

        // Precisamos atualizar o endereço também
        if(consulta.getPaciente() != null && consulta.getId() != null) {
            pacienteDaoH2.atualizar(consulta.getPaciente());
        }

        if(consulta.getDentista() != null && consulta.getId() != null) {
            dentistaDaoH2.atualizar(consulta.getDentista());
        }

        if(consulta.getUsuario() != null && consulta.getId() != null) {
            usuarioDaoH2.atualizar(consulta.getUsuario());
        }

        String query = String.format(
                "UPDATE consultas SET dataCad = '%s', dataAtend = '%s', WHERE id = '%s'",
                consulta.getDataCad(),
                consulta.getDataAtend());

        execute(conexao, query);

        return consulta;
    }

    private Consulta criarObjetoConsulta(ResultSet resultado) throws SQLException {
        Integer idRec = resultado.getInt("id");

        Paciente pacienteRec = pacienteDaoH2.buscar(
                resultado.getInt("id_paciente")).orElse(null);

        Dentista dentistaRec = dentistaDaoH2.buscar(
                resultado.getInt("id_dentista")).orElse(null);

        Usuario usuarioRec = usuarioDaoH2.buscar(
                resultado.getInt("id_usuario")).orElse(null);

        Date dataCadRec = resultado.getDate("dataCad");
        Date dataAtendRec = resultado.getDate("dataAtend");

        return new Consulta(idRec, pacienteRec, dentistaRec, usuarioRec, dataCadRec, dataAtendRec);
    }

    private void execute(Connection conexao, String query) {
        try {
            Statement stmt = conexao.createStatement();
            stmt.executeUpdate(query);
            stmt.close();
            conexao.close();
        }
        catch(SQLException e) {
            e.printStackTrace();
        }
    }
}
