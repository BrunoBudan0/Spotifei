
package Control;

import DAO.Conexao;
import DAO.MusicaDAO;
import Model.Musica;
import View.PesquisaMusica;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;


public class ControlMusica {
    private PesquisaMusica view;
    
    public ControlMusica(PesquisaMusica view) {
        this.view = view;
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
     public void atualizarListaMusicas(List<Musica> musicas) {
        view.setMusicas(musicas);
        view.limparLista();
        
        if (musicas.isEmpty()) {
            view.adicionarItemLista("Nenhuma musica encontrada");
        } else {
            for (Musica musica : musicas) {
                view.adicionarItemLista(musica.getNomeMusic());
                view.adicionarItemLista(musica.getDescricaoMusic());
                view.adicionarItemLista(musica.getArtistaMusic());
//                view.adicionarItemLista(musica.getDuracaoMusic());
            }
        }
        
        // Atualizar a interface
        view.atualizarInterface();
    }
}
