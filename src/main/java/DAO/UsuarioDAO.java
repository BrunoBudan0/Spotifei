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
        
        return statement.executeQuery();
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
    
    //Retirei os metodos de excluir e editar pois não são necessarios para o programa 
}