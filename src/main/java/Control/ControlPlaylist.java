package Control;

import DAO.PlaylistDAO;
import DAO.Conexao;
import Model.Musica;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import Model.Playlist;
import View.NewPlaylist;
import View.Playlists;
import View.AddPlaylists;
import java.util.List;

public class ControlPlaylist {
    private Object view;
    private TipoTela tipoTela;
    
    // Constructor para NewPlaylist
    public ControlPlaylist(NewPlaylist view) {
        this.view = view;
        this.tipoTela = TipoTela.GERAL;
    }
    
    // Constructor para Playlists
    public ControlPlaylist(Playlists view) {
        this.view = view;
        this.tipoTela = TipoTela.PLAYLIST;
    }
    
    // Constructor para AddPlaylists
    public ControlPlaylist(AddPlaylists view) {
        this.view = view;
        this.tipoTela = TipoTela.ADD; 
    }
    
    // Constructor genérico com tipo de tela
    public ControlPlaylist(Object view, TipoTela tipoTela) {
        this.view = view;
        this.tipoTela = tipoTela;
    }
    
    public boolean criarPlaylist() {
        if (!(view instanceof NewPlaylist)) {
            return false;
        }
        
        String nomePlaylist = ((NewPlaylist) view).getTxtNome().getText();
        
        if (nomePlaylist.isEmpty()) {
            JOptionPane.showMessageDialog((java.awt.Component) view, 
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
            
            JOptionPane.showMessageDialog((java.awt.Component) view, 
                "Playlist criada com sucesso!", 
                "Sucesso", 
                JOptionPane.INFORMATION_MESSAGE);
            return true;
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog((java.awt.Component) view, 
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
            
            atualizarListaPlaylists(playlists);
            
            conn.close();
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog((java.awt.Component) view, 
                "Erro ao carregar playlists: " + e.getMessage(), 
                "Erro", 
                JOptionPane.ERROR_MESSAGE);
        }
    }
    
    // Método unificado para atualizar lista de playlists
    public void atualizarListaPlaylists(List<Playlist> playlists) {
        // Atualizar a lista de playlists na view
        setPlaylistsNaView(playlists);
        limparListaNaView();
        
        if (playlists.isEmpty()) {
            adicionarItemNaView("Nenhuma playlist encontrada");
        } else {
            for (Playlist playlist : playlists) {
                String itemLista = formatarItemPorTela(playlist);
                adicionarItemNaView(itemLista);
            }
        }
        
        // Atualizar a interface
        atualizarInterfaceNaView();
    }
    
    // Método para formatar item baseado no tipo de tela
    private String formatarItemPorTela(Playlist playlist) {
        switch (tipoTela) {
            case PLAYLIST:
                return "📁 " + playlist.getNomePlaylist();
            case ADD:
                return "📁 " + playlist.getNomePlaylist();
            case GERAL:
            default:
                return playlist.getNomePlaylist();
        }
    }
    
    // Métodos auxiliares para trabalhar com diferentes views
    private void setPlaylistsNaView(List<Playlist> playlists) {
        if (view instanceof Playlists) {
            ((Playlists) view).setPlaylists(playlists);
        } else if (view instanceof AddPlaylists) {
            ((AddPlaylists) view).setPlaylists(playlists);
        }
    }
    
    private void limparListaNaView() {
        if (view instanceof Playlists) {
            ((Playlists) view).limparLista();
        } else if (view instanceof AddPlaylists) {
            ((AddPlaylists) view).limparLista();
        }
    }
    
    private void adicionarItemNaView(String item) {
        if (view instanceof Playlists) {
            ((Playlists) view).adicionarItemLista(item);
        } else if (view instanceof AddPlaylists) {
            ((AddPlaylists) view).adicionarItemLista(item);
        }
    }
    
    private void atualizarInterfaceNaView() {
        if (view instanceof Playlists) {
            ((Playlists) view).atualizarInterface();
        } else if (view instanceof AddPlaylists) {
            ((AddPlaylists) view).atualizarInterface();
        }
    }
     
    public boolean excluirPlaylist(Playlist playlist) {
        try {
            Connection conn = new Conexao().getConnection();
            PlaylistDAO dao = new PlaylistDAO(conn);
            
            dao.excluirPlaylist(playlist.getIdPlaylist());
            
            JOptionPane.showMessageDialog((java.awt.Component) view, 
                "Playlist excluída com sucesso!", 
                "Sucesso", 
                JOptionPane.INFORMATION_MESSAGE);
            
            conn.close();
            
            carregarPlaylists();
            
            return true;
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog((java.awt.Component) view, 
                "Erro ao excluir playlist: " + e.getMessage(), 
                "Erro", 
                JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }
    
    // Método para obter playlist selecionada
    public Playlist obterPlaylistSelecionada(int indice) {
        List<Playlist> playlists = null;
        
        if (view instanceof Playlists) {
            playlists = ((Playlists) view).getPlaylists();
        } else if (view instanceof AddPlaylists) {
            playlists = ((AddPlaylists) view).getPlaylists();
        }
        
        if (playlists != null && indice >= 0 && indice < playlists.size()) {
            return playlists.get(indice);
        }
        
        return null;
    }
    
    // Método para excluir a playlist 
    public void excluirPlaylistSelecionada(int indice) {
        Playlist playlist = obterPlaylistSelecionada(indice);
        
        if (playlist != null) {
            int confirmacao = JOptionPane.showConfirmDialog((java.awt.Component) view,
                "Tem certeza que deseja excluir a playlist '" + playlist.getNomePlaylist() + "'?",
                "Confirmar Exclusão",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE);
            
            if (confirmacao == JOptionPane.YES_OPTION) {
                excluirPlaylist(playlist);
            }
        } else {
            JOptionPane.showMessageDialog((java.awt.Component) view, 
                "Selecione uma playlist para excluir", 
                "Aviso", 
                JOptionPane.WARNING_MESSAGE);
        }
    }
    
    public boolean adicionarMusicaAPlaylist(Musica musica, Playlist playlist) {
        try {
            Connection conn = new Conexao().getConnection();
            PlaylistDAO dao = new PlaylistDAO(conn);
            
            dao.adicionarMusicaAPlaylist(playlist.getIdPlaylist(), musica.getIdMusic());
            
            conn.close();
            
            return true;
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog((java.awt.Component) view, 
                "Erro ao adicionar música à playlist: " + e.getMessage(), 
                "Erro", 
                JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }
}