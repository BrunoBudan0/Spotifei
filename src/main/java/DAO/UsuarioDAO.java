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
    
    public ResultSet consultar(Usuario usuario) throws SQLException{
        String sql = "select * from Usuario where nome_usuario = ? and senha_usuario = ?";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(1, usuario.getNomeUsuario());
        statement.setInt(2, usuario.getSenhaUsuario());
        statement.execute();
        ResultSet resultado = statement.getResultSet();
        return resultado;
    }
    public void inserir(Usuario usuario) throws SQLException{
        String sql = "insert into Usuario (nome_usuario, email_usuario, senha_usuario) values ('"
                      + usuario.getNomeUsuario()    + "', '"
                      + usuario.getEmailUsuario() + "', '"
                      + usuario.getSenhaUsuario()   + "')";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.execute();
        conn.close();
    }
//    Colocar as demias funções de excluir e alterar
}
