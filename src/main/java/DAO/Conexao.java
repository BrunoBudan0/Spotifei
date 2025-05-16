
package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
    // Constantes de conexão - ajuste conforme suas configurações
    private static final String URL = "jdbc:postgresql://localhost:5432/spotifei";
    private static final String USER = "postgres";
    private static final String PASSWORD = "bru03050";
    
    // Método para obter a conexão
    public Connection getConnection() throws SQLException {
        try {
            // Registra o driver JDBC
            Class.forName("org.postgresql.Driver");
            
            // Retorna a conexão
            return DriverManager.getConnection(URL, USER, PASSWORD);
            
        } catch (ClassNotFoundException e) {
            throw new SQLException("Driver do PostgreSQL não encontrado", e);
        }
    }
    
    // Método para fechar a conexão
    public static void closeConnection(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                System.err.println("Erro ao fechar conexão: " + e.getMessage());
            }
        }
    }
}
