
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
    
    public void loginUsuario(){
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
            return; // Encerra o método se a senha não for um número
        }
        
        Usuario usuario = new Usuario(null, 
                                view.getTxtLogin().getText(),
                                senhaInt);
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
                Usuario dadosUsu = new Usuario(res.getString("nome"), 
                                         res.getString("usuario"), 
                                         res.getInt("senha"));
                
                // Como você não tem a tela AltExcFrame ainda, podemos comentar estas linhas
                // ou substituir por uma mensagem ou outra ação temporária
                // AltExcFrame aec = new AltExcFrame(dadosUsu);
                // aec.setVisible(true);
                
                // Em vez disso, podemos mostrar uma mensagem temporária:
                JOptionPane.showMessageDialog(view, 
                                             "Usuário autenticado: " + dadosUsu.getNomeUsuario(), 
                                             "Sucesso", 
                                             JOptionPane.INFORMATION_MESSAGE);
                
                // Aqui você pode adicionar qualquer lógica temporária que deseja executar 
                // após o login bem-sucedido
                
            } else{
                JOptionPane.showMessageDialog(view, 
                                              "Login NÃO efetuado!", 
                                              "Aviso",
                                              JOptionPane.ERROR_MESSAGE);
            }
        } catch(SQLException e){    
            JOptionPane.showMessageDialog(view, 
                                              "Erro de conexão!", 
                                              "Aviso",
                                              JOptionPane.ERROR_MESSAGE);
        }
    }
}
