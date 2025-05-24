
package Control;

import DAO.Conexao;
import DAO.MusicaDAO;
import Model.Musica;
import View.CurtidasMusicas;
import View.PesquisaMusica;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;


public class ControlMusica {
    private PesquisaMusica view;
    private CurtidasMusicas viewCurtidas;
    
    public ControlMusica(PesquisaMusica view) {
        this.view = view;
    }
    public ControlMusica(CurtidasMusicas view) {
        this.viewCurtidas = view;
    }
    
    public void carregarMusicas(String input) {
        try {
            Connection conn = new Conexao().getConnection();
            MusicaDAO dao = new MusicaDAO(conn);
            
            List<Musica> musicas = dao.buscarMusica(input);
            
            atualizarListaMusicas(musicas);
            
            conn.close();
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(view, 
                "Erro ao carregar musicas: " + e.getMessage(), 
                "Erro", 
                JOptionPane.ERROR_MESSAGE);
        }
    }
    public void carregarMusicasCurtidas() {
        try {
            Connection conn = new Conexao().getConnection();
            MusicaDAO dao = new MusicaDAO(conn);
            
            List<Musica> musicas = dao.buscarMusicaCurtida(SessaoUsuario.getUsuarioLogado().getIdUsuario());
            
            atualizarListaMusicasCurtidas(musicas);
            
            conn.close();
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(viewCurtidas, 
                "Erro ao carregar musicas: " + e.getMessage(), 
                "Erro", 
                JOptionPane.ERROR_MESSAGE);
        }
    }
     public void atualizarListaMusicas(List<Musica> musicas) {
        view.setMusicas(musicas);
        view.limparLista();
        
        if (musicas.isEmpty()) {
            view.adicionarItemLista("Nenhuma musica encontrada");
        } else {
            for (Musica musica : musicas) {
                String itemLista = musica.getNomeMusic() + " / " 
                        + musica.getArtistaMusic() + " / " 
                        + musica.getDuracaoMusic();
                view.adicionarItemLista(itemLista);
            }
        }
        // Atualizar a interface
        view.atualizarInterface();
    }
     
     //VERIFICAR SE ESTÁ FUNCIONANDO DEPOIS EXCLUIR
     public void atualizarListaMusicasCurtidas(List<Musica> musicas) {
        viewCurtidas.setMusicas(musicas);
        viewCurtidas.limparLista();
        
        if (musicas.isEmpty()) {
            viewCurtidas.adicionarItemLista("Nenhuma musica encontrada");
        } else {
            for (Musica musica : musicas) {
                String itemLista = "❤ ️" + musica.getNomeMusic() + " / " 
                        + musica.getArtistaMusic() + " / " 
                        + musica.getDuracaoMusic();
                viewCurtidas.adicionarItemLista(itemLista);
            }
        }
        // Atualizar a interface
        viewCurtidas.atualizarInterface();
    }
     public Musica obterMusicaSelecionadaCurtida(int indice) {
        List<Musica> musica = viewCurtidas.getMusicas();
        
        if (indice >= 0 && indice < musica.size()) {
            return musica.get(indice);
        }
        
        return null;
    }
     
     //VERIFICAR SE ESTÁ FUNCIONANDO DEPOIS EXCLUIR
     
    // Método para obter musica selecionada
    public Musica obterMusicaSelecionada(int indice) {
        List<Musica> musica = view.getMusicas();
        
        if (indice >= 0 && indice < musica.size()) {
            return musica.get(indice);
        }
        
        return null;
    }
    public boolean curtirMusica(Musica musica) {
        try {
            Connection conn = new Conexao().getConnection();
            MusicaDAO dao = new MusicaDAO(conn);
            
            dao.curtirMusicas(musica);
            
            JOptionPane.showMessageDialog(view, 
                                             "Curtida: " + musica.getNomeMusic()+"!", 
                                             "Sucesso", 
                                             JOptionPane.INFORMATION_MESSAGE);
            
            conn.close();
            
            return true;
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(view, 
                "Erro ao curtir musica: " + e.getMessage(), 
                "Erro", 
                JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }
            
    //Metodo para excluir a playlist 
    public void curtirMusicaSelecionada(int indice) {
        Musica musica = obterMusicaSelecionada(indice);
        
        if (musica != null) {
            curtirMusica(musica);
          
        } else {
            JOptionPane.showMessageDialog(view, 
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
            JOptionPane.showMessageDialog(viewCurtidas, 
                "Erro ao descurtir musica: " + e.getMessage(), 
                "Erro", 
                JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }
    //Metodo para excluir a playlist 
    public void descurtirMusicaSelecionada(int indice) {
        Musica musica = obterMusicaSelecionadaCurtida(indice);
        
        if (musica != null) {
            int confirmacao = JOptionPane.showConfirmDialog(viewCurtidas,
                "Tem certeza que deseja descurtir a musica '" + musica.getNomeMusic()+ "'?",
                "Confirmar Exclusão",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE);
            
            if (confirmacao == JOptionPane.YES_OPTION) {
                descurtirMusica(musica);
            }
        } else {
            JOptionPane.showMessageDialog(viewCurtidas, 
                "Selecione uma musica para descurtir", 
                "Aviso", 
                JOptionPane.WARNING_MESSAGE);
        }
    }
}
