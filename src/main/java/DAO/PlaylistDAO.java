package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import Model.Playlist;
import Control.SessaoUsuario;
import Model.Usuario;

public class PlaylistDAO {
    private Connection conn;
    
    public PlaylistDAO(Connection conn) {
        this.conn = conn;
    }
    
    public void Criar(Playlist playlist) throws SQLException {
        String sql = "INSERT INTO playlist (nome_playlist, id_usuario,nome_usuario) VALUES (?, ?, ?)";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(1, playlist.getNomePlaylist());
        Usuario usuarioLogado = SessaoUsuario.getUsuarioLogado();
        statement.setInt(2, usuarioLogado.getIdUsuario());
        statement.setString(3, usuarioLogado.getNomeUsuario());
        statement.execute();
        conn.close();
    }
}