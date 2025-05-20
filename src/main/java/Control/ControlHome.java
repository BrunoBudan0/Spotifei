
package Control;

import DAO.MusicaDAO;
import DAO.UsuarioDAO;
import DAO.Conexao;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import Model.Musica;
import Model.Usuario;
import View.Home;
import java.sql.ResultSet;

public class ControlHome {
    private Musica musica;
    private Home view;
    private Usuario usuario;
    
    public ControlHome(Home view){
        this.view = view;
    }
    
    public void Pesquisa(){
        String dado = view.getTxtPesquisa().getText();
        
        Musica musica = new Musica(dado);
        Conexao conexao = new Conexao();
        try{
            Connection conn = conexao.getConnection();
            MusicaDAO dao = new MusicaDAO(conn);
            ResultSet res = dao.busca(musica);
            if(res.next()){
            
            }
        }catch(SQLException e){
        }
    }
    
}

