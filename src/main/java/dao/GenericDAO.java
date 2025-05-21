package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

abstract public class GenericDAO {

    public GenericDAO() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public Connection getConnection() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/sistema_consultas?useSSL=false&serverTimezone=UTC";
        String user = "root";
        String password = "root";

        return DriverManager.getConnection(url, user, password);
    }
}

class TesteConexao {
    public static void main(String[] args) {
        GenericDAO dao = new GenericDAO() {}; // instancia anônima, pois GenericDAO é abstrata
        try (Connection conn = dao.getConnection()) {
            if (conn != null && !conn.isClosed()) {
                System.out.println("Conexão bem-sucedida!");
            } else {
                System.out.println("Falha na conexão.");
            }
        } catch (SQLException e) {
            System.out.println("Erro ao tentar conectar ao banco:");
            e.printStackTrace();
        }
    }
}
