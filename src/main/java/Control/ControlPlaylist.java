package Control;

import DAO.PlaylistDAO;
import DAO.Conexao;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import Model.Playlist;
import View.NewPlaylist;
import View.Playlists;
import java.util.List;

public class ControlPlaylist {
    private NewPlaylist view;
    private Playlists viewPlaylists;
    
    public ControlPlaylist(NewPlaylist view) {
        this.view = view;
    }
    public ControlPlaylist(Playlists view) {
        this.viewPlaylists = view;
    }
    
    public boolean criarPlaylist() {
        String nomePlaylist = view.getTxtNome().getText();
        
        if (nomePlaylist.isEmpty()) {
            JOptionPane.showMessageDialog(view, 
                "O nome da playlist não pode estar vazio", 
                "Erro", 
                JOptionPane.ERROR_MESSAGE);
            return false;
        }
        
        try {
            Connection conn = new Conexao().getConnection();
            PlaylistDAO dao = new PlaylistDAO(conn);
            
            Playlist playlist = new Playlist(nomePlaylist, SessaoUsuario.getUsuarioLogado());
            dao.Criar(playlist);
            
            JOptionPane.showMessageDialog(view, 
                "Playlist criada com sucesso!", 
                "Sucesso", 
                JOptionPane.INFORMATION_MESSAGE);
            return true;
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(view, 
                "Erro ao criar playlist: " + e.getMessage(), 
                "Erro", 
                JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }
    // Método para carregar playlists do usuário logado
    public void carregarPlaylists() {
        
        try {
            Connection conn = new Conexao().getConnection();
            PlaylistDAO dao = new PlaylistDAO(conn);
            
            List<Playlist> playlists = dao.buscarPlaylists(SessaoUsuario.getUsuarioLogado().getIdUsuario());
            
            viewPlaylists.atualizarListaPlaylists(playlists);
            
            conn.close();
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(viewPlaylists, 
                "Erro ao carregar playlists: " + e.getMessage(), 
                "Erro", 
                JOptionPane.ERROR_MESSAGE);
        }
    }
    
}
