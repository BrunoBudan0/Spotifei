
package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import Model.Musica;

public class MusicaDAO {
    private Connection conn;

    public MusicaDAO(Connection conn) {
        this.conn = conn;
    }
    
    public ResultSet busca(Musica musica) throws SQLException {
        String sql = "SELECT * FROM musica WHERE nome_musica = ?";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(1, musica.getNomeMusic());
        
        return statement.executeQuery();
    }
    
}
