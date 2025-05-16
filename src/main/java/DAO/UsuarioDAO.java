package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import Model.Usuario;

public class UsuarioDAO {
    private Connection conn;

    public UsuarioDAO(Connection conn) {
        this.conn = conn;
    }
    
    public ResultSet consultar(Usuario usuario) throws SQLException {
        String sql = "SELECT * FROM usuario WHERE nome_usuario = ? AND senha_usuario = ?";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(1, usuario.getNomeUsuario());
        statement.setInt(2, usuario.getSenhaUsuario());
        statement.execute();
        return statement.getResultSet();
    }
    
    public void inserir(Usuario usuario) throws SQLException {
        String sql = "INSERT INTO usuario (nome_usuario, email_usuario, senha_usuario) VALUES (?, ?, ?)";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(1, usuario.getNomeUsuario());
        statement.setString(2, usuario.getEmailUsuario());
        statement.setInt(3, usuario.getSenhaUsuario());
        statement.execute();
        conn.close();
    }
    
    // Métodos para implementar no futuro: excluir e alterar
    public void excluir(int idUsuario) throws SQLException {
        String sql = "DELETE FROM usuario WHERE id_usuario = ?";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setInt(1, idUsuario);
        statement.execute();
        conn.close();
    }
    
    public void alterar(Usuario usuario) throws SQLException {
        String sql = "UPDATE usuario SET nome_usuario = ?, email_usuario = ?, senha_usuario = ? WHERE id_usuario = ?";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(1, usuario.getNomeUsuario());
        statement.setString(2, usuario.getEmailUsuario());
        statement.setInt(3, usuario.getSenhaUsuario());
        statement.setInt(4, usuario.getIdUsuario());
        statement.execute();
        conn.close();
    }
}