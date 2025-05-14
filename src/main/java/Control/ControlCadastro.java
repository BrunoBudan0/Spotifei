
package control;

import DAO.UsuarioDAO;
import DAO.Conexao;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import Model.Usuario;
import View.Cadastro;

public class ControlCadastro {
    private Cadastro view;
    
    public ControlCadastro(Cadastro view){
        this.view = view;
    }
    
    public void salvarUsuario(){
        String nome = view.getTxt_nome_cadastro().getText();
        String email = view.getTxt_usuario_cadastro().getText();
        int senha = view.getTxt_senha_cadastro().getint();
        Usuario usuario = new Usuario(nome, email,senha);
        
        Conexao conexao = new Conexao();
        try {
            Connection conn = conexao.getConnection();
            UsuarioDAO dao = new UsuarioDAO(conn);
            dao.inserir(usuario);
            JOptionPane.showMessageDialog(view, "Usuario Cadastrado!","Aviso", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(view, "Usuário não cadastrado!","Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
}
