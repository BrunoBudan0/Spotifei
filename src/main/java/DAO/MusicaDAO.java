
package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import Control.SessaoUsuario;
import Model.Musica;
import Model.Usuario;
import java.util.ArrayList;
import java.util.List;

public class MusicaDAO {
    private Connection conn;

    public MusicaDAO(Connection conn) {
        this.conn = conn;
    }
    
    public List<Musica> buscarMusica(String input) throws SQLException {
    List<Musica> musicas = new ArrayList<>();
    
    //Like ajuda na pesquisa parcial
    String sql = "SELECT * FROM musica WHERE nome_musica LIKE ? OR nome_artista LIKE ?";
    
    PreparedStatement statement = conn.prepareStatement(sql);
    
    // Corrigido: definir todos os parâmetros e usar % para busca parcial
    String searchTerm = "%" + input + "%";
    statement.setString(1, searchTerm);
    statement.setString(2, searchTerm);
    
    ResultSet res = statement.executeQuery();
    
    while (res.next()) {
        Musica musica = new Musica();
        musica.setIdMusic(res.getInt("id_musica"));
        musica.setNomeMusic(res.getString("nome_musica"));
        musica.setDuracaoMusic(res.getTime("duracao_musica"));
        musica.setArtistaMusic(res.getString("nome_artista"));
        musica.setDescricaoMusic(res.getString("descricao_musica"));

        musicas.add(musica);
    }
    
    res.close();
    statement.close();
    return musicas;
}
    
    public List<Musica> buscarMusicaCurtida(int idUsuario) throws SQLException {
        List<Musica> musicas = new ArrayList<>();
        String sql = "SELECT * FROM musicascurtidas WHERE id_usuario = ?";
        
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setInt(1, idUsuario);
        ResultSet res = statement.executeQuery();
        
        while (res.next()) {
            Musica musica = new Musica();
            musica.setIdMusic(res.getInt("id_musica")); 
            String sql2 = "SELECT * FROM musica WHERE id_musica = ?";
        
            PreparedStatement statement2 = conn.prepareStatement(sql2);
            statement2.setInt(1, musica.getIdMusic());
            ResultSet res2 = statement2.executeQuery();
            while (res2.next()) {
                musica.setNomeMusic(res2.getString("nome_musica"));
                musica.setDuracaoMusic(res2.getTime("duracao_musica"));
                musica.setArtistaMusic(res2.getString("nome_artista"));
            }

               musicas.add(musica);
        }
        
        res.close();
        statement.close();
        return musicas;
    }
    
    public void curtirMusicas(Musica musica) throws SQLException {
        String sql = "INSERT INTO musicascurtidas (id_usuario, id_musica) VALUES (?, ?)";
        PreparedStatement statement = conn.prepareStatement(sql);
        Usuario usuarioLogado = SessaoUsuario.getUsuarioLogado();
        statement.setInt(1, usuarioLogado.getIdUsuario());
        statement.setInt(2, musica.getIdMusic());
        statement.execute();
        conn.close();
    }
    
}
