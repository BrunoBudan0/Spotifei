package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import Model.Playlist;
import Control.SessaoUsuario;
import Model.Usuario;
import java.util.ArrayList;
import java.util.List;


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
     public List<Playlist> buscarPlaylists(int idUsuario) throws SQLException {
        List<Playlist> playlists = new ArrayList<>();
        String sql = "SELECT * FROM playlist WHERE id_usuario = ?";
        
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setInt(1, idUsuario);
        ResultSet res = statement.executeQuery();
        
        while (res.next()) {
            Playlist playlist = new Playlist();
            playlist.setIdPlaylist(res.getInt("id_playlist")); // Assumindo que existe campo id_playlist
            playlist.setNomePlaylist(res.getString("nome_playlist"));
            
               playlists.add(playlist);
        }
        
        res.close();
        statement.close();
        return playlists;
    }
    public void excluirPlaylist(int idPlaylist) throws SQLException {
        String sql = "DELETE FROM playlist WHERE id_playlist = ?";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setInt(1, idPlaylist);
        statement.execute();
        conn.close();
    }
}