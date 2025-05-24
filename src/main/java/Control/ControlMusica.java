package Control;

import DAO.Conexao;
import DAO.MusicaDAO;
import Model.Musica;
import View.CurtidasMusicas;
import View.PesquisaMusica;
import View.PlaylistMusica;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;

public class ControlMusica {
    private Object view; // View genérica
    private TipoTela tipoTela;
    
    
    // Constructor para PesquisaMusica
    public ControlMusica(PesquisaMusica view) {
        this.view = view;
        this.tipoTela = TipoTela.PESQUISA;
    }
    
    // Constructor para CurtidasMusicas
    public ControlMusica(CurtidasMusicas view) {
        this.view = view;
        this.tipoTela = TipoTela.CURTIDAS;
    }
    
    // Constructor para PlaylistMusica
    public ControlMusica(PlaylistMusica view) {
        this.view = view;
        this.tipoTela = TipoTela.PLAYLIST_MUSICA;
    }
    
    // Constructor genérico com tipo de tela
    public ControlMusica(Object view, TipoTela tipoTela) {
        this.view = view;
        this.tipoTela = tipoTela;
    }
    
    public void carregarMusicas(String input) {
        try {
            Connection conn = new Conexao().getConnection();
            MusicaDAO dao = new MusicaDAO(conn);
            
            List<Musica> musicas = dao.buscarMusica(input);
            
            atualizarListaMusicas(musicas);
            
            conn.close();
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog((java.awt.Component) view, 
                "Erro ao carregar musicas: " + e.getMessage(), 
                "Erro", 
                JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void carregarMusicasPlaylist() {
        if (!(view instanceof PlaylistMusica)) {
            return;
        }
        
        PlaylistMusica playlistView = (PlaylistMusica) view;
        Integer idPlaylist = playlistView.getIdPlaylistAtual();
        
        if (idPlaylist == null) {
            return;
        }
        
        try {
            Connection conn = new Conexao().getConnection();
            MusicaDAO dao = new MusicaDAO(conn);
            
            List<Musica> musicas = dao.buscarMusicasPlaylist(idPlaylist);
            
            atualizarListaMusicas(musicas);
            
            conn.close();
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog((java.awt.Component) view, 
                "Erro ao carregar músicas da playlist: " + e.getMessage(), 
                "Erro", 
                JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void carregarMusicasCurtidas() {
        try {
            Connection conn = new Conexao().getConnection();
            MusicaDAO dao = new MusicaDAO(conn);
            
            List<Musica> musicas = dao.buscarMusicaCurtida(SessaoUsuario.getUsuarioLogado().getIdUsuario());
            
            atualizarListaMusicas(musicas);
            
            conn.close();
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog((java.awt.Component) view, 
                "Erro ao carregar musicas curtidas: " + e.getMessage(), 
                "Erro", 
                JOptionPane.ERROR_MESSAGE);
        }
    }
    
    // Método unificado para atualizar lista de músicas
    public void atualizarListaMusicas(List<Musica> musicas) {
        // Definir as músicas na view
        setMusicasNaView(musicas);
        limparListaNaView();
        
        if (musicas.isEmpty()) {
            adicionarItemNaView("Nenhuma musica encontrada");
        } else {
            for (Musica musica : musicas) {
                String itemLista = formatarItemPorTela(musica);
                adicionarItemNaView(itemLista);
            }
        }
        
        // Atualizar a interface
        atualizarInterfaceNaView();
    }
    
    // Método para formatar item baseado no tipo de tela
    private String formatarItemPorTela(Musica musica) {
        switch (tipoTela) {
            case PESQUISA:
                return musica.getNomeMusic() + " / " 
                        + musica.getArtistaMusic() + " / " 
                        + musica.getDuracaoMusic();
            case CURTIDAS:
                return "♥ " + musica.getNomeMusic() + " / " 
                        + musica.getArtistaMusic() + " / " 
                        + musica.getDuracaoMusic();
            case PLAYLIST_MUSICA:
                return "🎵 " + musica.getNomeMusic() + " - " + musica.getArtistaMusic();
            default:
                return musica.getNomeMusic();
        }
    }
    
    // Métodos auxiliares para trabalhar com diferentes views
    private void setMusicasNaView(List<Musica> musicas) {
        switch (tipoTela) {
            case PESQUISA:
                ((PesquisaMusica) view).setMusicas(musicas);
                break;
            case CURTIDAS:
                ((CurtidasMusicas) view).setMusicas(musicas);
                break;
            case PLAYLIST_MUSICA:
                ((PlaylistMusica) view).setMusicas(musicas);
                break;
        }
    }
    
    private void limparListaNaView() {
        switch (tipoTela) {
            case PESQUISA:
                ((PesquisaMusica) view).limparLista();
                break;
            case CURTIDAS:
                ((CurtidasMusicas) view).limparLista();
                break;
            case PLAYLIST_MUSICA:
                ((PlaylistMusica) view).limparLista();
                break;
        }
    }
    
    private void adicionarItemNaView(String item) {
        switch (tipoTela) {
            case PESQUISA:
                ((PesquisaMusica) view).adicionarItemLista(item);
                break;
            case CURTIDAS:
                ((CurtidasMusicas) view).adicionarItemLista(item);
                break;
            case PLAYLIST_MUSICA:
                ((PlaylistMusica) view).adicionarItemLista(item);
                break;
        }
    }
    
    private void atualizarInterfaceNaView() {
        switch (tipoTela) {
            case PESQUISA:
                ((PesquisaMusica) view).atualizarInterface();
                break;
            case CURTIDAS:
                ((CurtidasMusicas) view).atualizarInterface();
                break;
            case PLAYLIST_MUSICA:
                ((PlaylistMusica) view).atualizarInterface();
                break;
        }
    }
    
    // Método unificado para obter música selecionada
    public Musica obterMusicaSelecionada(int indice) {
        List<Musica> musicas = null;
        
        switch (tipoTela) {
            case PESQUISA:
                musicas = ((PesquisaMusica) view).getMusicas();
                break;
            case CURTIDAS:
                musicas = ((CurtidasMusicas) view).getMusicas();
                break;
            case PLAYLIST_MUSICA:
                musicas = ((PlaylistMusica) view).getMusicas();
                break;
        }
        
        if (musicas != null && indice >= 0 && indice < musicas.size()) {
            return musicas.get(indice);
        }
        
        return null;
    }
    
    public boolean removerMusicaPlaylist(Musica musica) {
        if (!(view instanceof PlaylistMusica)) {
            return false;
        }
        
        PlaylistMusica playlistView = (PlaylistMusica) view;
        Integer idPlaylist = playlistView.getIdPlaylistAtual();
        
        if (idPlaylist == null) {
            return false;
        }
        
        try {
            Connection conn = new Conexao().getConnection();
            MusicaDAO dao = new MusicaDAO(conn);
            
            dao.removerMusicaPlaylist(idPlaylist, musica.getIdMusic());
            
            JOptionPane.showMessageDialog((java.awt.Component) view, 
                "Música removida da playlist com sucesso!", 
                "Sucesso", 
                JOptionPane.INFORMATION_MESSAGE);
            
            conn.close();
            
            carregarMusicasPlaylist();
            
            return true;
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog((java.awt.Component) view, 
                "Erro ao remover música da playlist: " + e.getMessage(), 
                "Erro", 
                JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }
    
    public void removerMusicaPlaylistSelecionada(int indice) {
        Musica musica = obterMusicaSelecionada(indice);
        
        if (musica != null) {
            int confirmacao = JOptionPane.showConfirmDialog((java.awt.Component) view,
                "Tem certeza que deseja remover a música '" + musica.getNomeMusic()+ "' da playlist?",
                "Confirmar Remoção",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE);
            
            if (confirmacao == JOptionPane.YES_OPTION) {
                removerMusicaPlaylist(musica);
            }
        } else {
            JOptionPane.showMessageDialog((java.awt.Component) view, 
                "Selecione uma música para remover", 
                "Aviso", 
                JOptionPane.WARNING_MESSAGE);
        }
    }
    
    //Para evitar mais edição
    public Musica obterMusicaSelecionadaCurtida(int indice) {
        return obterMusicaSelecionada(indice);
    }
    
    public boolean curtirMusica(Musica musica) {
        try {
            Connection conn = new Conexao().getConnection();
            MusicaDAO dao = new MusicaDAO(conn);
            
            dao.curtirMusicas(musica);
            
            JOptionPane.showMessageDialog((java.awt.Component) view, 
                                             "Curtida: " + musica.getNomeMusic()+"!", 
                                             "Sucesso", 
                                             JOptionPane.INFORMATION_MESSAGE);
            
            conn.close();
            
            return true;
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog((java.awt.Component) view, 
                "Erro ao curtir musica: " + e.getMessage(), 
                "Erro", 
                JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }
            
    public void curtirMusicaSelecionada(int indice) {
        Musica musica = obterMusicaSelecionada(indice);
        
        if (musica != null) {
            curtirMusica(musica);
        } else {
            JOptionPane.showMessageDialog((java.awt.Component) view, 
                "Selecione uma musica para curtir", 
                "Aviso", 
                JOptionPane.WARNING_MESSAGE);
        }
    }
    
    public boolean descurtirMusica(Musica musica) {
        try {
            Connection conn = new Conexao().getConnection();
            MusicaDAO dao = new MusicaDAO(conn);
            
            dao.descurtirMusica(musica.getIdMusic());
            
            conn.close();
            
            carregarMusicasCurtidas();
            
            return true;
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog((java.awt.Component) view, 
                "Erro ao descurtir musica: " + e.getMessage(), 
                "Erro", 
                JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }
    
    public void descurtirMusicaSelecionada(int indice) {
        Musica musica = obterMusicaSelecionada(indice);
        
        if (musica != null) {
            int confirmacao = JOptionPane.showConfirmDialog((java.awt.Component) view,
                "Tem certeza que deseja descurtir a musica '" + musica.getNomeMusic()+ "'?",
                "Confirmar Exclusão",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE);
            
            if (confirmacao == JOptionPane.YES_OPTION) {
                descurtirMusica(musica);
            }
        } else {
            JOptionPane.showMessageDialog((java.awt.Component) view, 
                "Selecione uma musica para descurtir", 
                "Aviso", 
                JOptionPane.WARNING_MESSAGE);
        }
    }
}