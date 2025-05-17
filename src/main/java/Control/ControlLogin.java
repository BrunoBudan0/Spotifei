
package Control;

import DAO.UsuarioDAO;
import DAO.Conexao;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import Model.Usuario;
import View.Login;


public class ControlLogin {
    private Login view;

    public ControlLogin(Login view) {
        this.view = view;
    }
    
    public boolean loginUsuario(){
         // Convertendo o array de caracteres para String e depois para int
        char[] senhaChars = view.getSenha().getPassword();
        String senhaStr = new String(senhaChars);
        int senhaInt;
        
        try {
            senhaInt = Integer.parseInt(senhaStr);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(view, 
                                         "Senha deve ser um número!", 
                                         "Erro de formato", 
                                         JOptionPane.ERROR_MESSAGE);
            return false; // Encerra o método se a senha não for um número
        }
        
        Usuario usuario = new Usuario(view.getTxtLogin().getText(),senhaInt);
        Conexao conexao = new Conexao();
        try{
            Connection conn = conexao.getConnection();
            UsuarioDAO dao = new UsuarioDAO(conn);
            ResultSet res = dao.consultar(usuario);
            if(res.next()){
                JOptionPane.showMessageDialog(view, 
                                              "Login efetuado!", 
                                              "Aviso",
                                              JOptionPane.INFORMATION_MESSAGE);
                Usuario dadosUsu = new Usuario(res.getInt("id_usuario"),
                                         res.getString("nome_usuario"), 
                                         res.getString("email_usuario"), 
                                         res.getInt("senha_usuario"));
                
                JOptionPane.showMessageDialog(view, 
                                             "Bem-vindo " + dadosUsu.getNomeUsuario()+"!", 
                                             "Sucesso", 
                                             JOptionPane.INFORMATION_MESSAGE);
                return true;
                     
            } else{
                JOptionPane.showMessageDialog(view, 
                                              "Login NÃO efetuado!", 
                                              "Aviso",
                                              JOptionPane.ERROR_MESSAGE);
                return false;
            }
        } catch(SQLException e){    
            JOptionPane.showMessageDialog(view, 
                                              "Erro de conexão!", 
                                              "Aviso",
                                              JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }
}
