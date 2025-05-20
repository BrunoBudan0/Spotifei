package Control;

import DAO.PlaylistDAO;
import DAO.Conexao;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import Model.Playlist;
import View.NewPlaylist;

public class ControlPlaylist {
    private NewPlaylist view;
    
    public ControlPlaylist(NewPlaylist view) {
        this.view = view;
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
}
