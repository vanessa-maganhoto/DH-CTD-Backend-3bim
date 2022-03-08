import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Main {

    private static final String SQL_CREATE_TABLE ="DROP TABLE IF EXISTS figuras;" +
            "CREATE TABLE figuras(" +
            "id int PRIMARY KEY, " +
            "figura varchar(64) not null, " +
            "cor varchar(64) not null) ";

    private static final String SQL_INSERT1 = "INSERT INTO figuras" +
            "(id, figura, cor) VALUES " +
            "(1, 'circulo', 'amarelo');";

    private static final String SQL_INSERT2 = "INSERT INTO figuras" +
            "(id, figura, cor) VALUES " +
            "(2, 'circulo', 'vermelho');";

    private static final String SQL_INSERT3 = "INSERT INTO figuras" +
            "(id, figura, cor) VALUES " +
            "(3, 'quadrado', 'violeta');";

    private static final String SQL_INSERT4 = "INSERT INTO figuras" +
            "(id, figura, cor) VALUES " +
            "(4, 'quadrado', 'rosa');";

    private static final String SQL_INSERT5 = "INSERT INTO figuras" +
            "(id, figura, cor) VALUES " +
            "(5, 'quadrado', 'vermelho');";

    public static void main(String[] args) throws Exception {
        Connection connection = null;

        try {
            connection = getConnection();
            Statement statement = connection.createStatement();
            statement.execute(SQL_CREATE_TABLE);

            Statement stateInsert1 = connection.createStatement();
            stateInsert1.execute(SQL_INSERT1);

            Statement stateInsert2 = connection.createStatement();
            stateInsert2.execute(SQL_INSERT2);

            Statement stateInsert3 = connection.createStatement();
            stateInsert3.execute(SQL_INSERT3);

            Statement stateInsert4 = connection.createStatement();
            stateInsert4.execute(SQL_INSERT4);

            Statement stateInsert5 = connection.createStatement();
            stateInsert5.execute(SQL_INSERT5);

            String sql = "SELECT * FROM figuras WHERE figura = 'circulo' AND cor ='vermelho' ";
            Statement selectFiguras = connection.createStatement();
            ResultSet rs = selectFiguras.executeQuery(sql);

            while(rs.next()){
                System.out.println(rs.getInt(1) + " | " +
                        rs.getString(2) + " | " +
                        rs.getString(3) ) ;
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            connection.close();
        }
    }

    public static Connection getConnection() throws Exception {
        return DriverManager.getConnection("jdbc:h2:mem:aula11Mesa", "sa", "");
    }
}
