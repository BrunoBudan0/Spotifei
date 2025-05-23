
package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import Model.Musica;
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
    
}
