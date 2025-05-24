
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
    private Usuario usuario;
    
    public ControlCadastro(Cadastro view){
        this.view = view;
    }
    
    public boolean salvarUsuario(){
        String nome = view.getTxtNome().getText();
        String email = view.getTxtEmail().getText();
        
        //Obter a senha como int do JPasswordField
        int senha;
        try {
            // Obtém a senha como array de caracteres
            char[] senhaChars = view.getSenha().getPassword();
            // Converte para String
            String senhaStr = new String(senhaChars);
            // Converte para inteiro
            senha = Integer.parseInt(senhaStr);
            // Limpa o array de caracteres da senha por segurança
            java.util.Arrays.fill(senhaChars, '0');
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(view, 
                "A senha deve conter apenas números!", 
                "Erro de validação", 
                JOptionPane.ERROR_MESSAGE);
            return false; // Sai do método se a senha não for um número válido
        }

        if (campoVazio(nome) || campoVazio(email)) {
            JOptionPane.showMessageDialog(view, 
                "Todos os campos precisam ser preenchidos!", 
                "Erro de validação", 
                JOptionPane.ERROR_MESSAGE);
            return false;
        }
        else{
        
            Usuario usuario = new Usuario(nome, email, senha);

            Conexao conexao = new Conexao();
            try {
                Connection conn = conexao.getConnection();
                UsuarioDAO dao = new UsuarioDAO(conn);
                dao.inserir(usuario);
                JOptionPane.showMessageDialog(view, 
                    "Usuário Cadastrado!", 
                    "Aviso", 
                    JOptionPane.INFORMATION_MESSAGE);

                //Limpar campos do cadastro
                limparCampos();
                return true;

            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(view, 
                    "Usuário não cadastrado! Erro: " + ex.getMessage(), 
                    "Erro", 
                    JOptionPane.ERROR_MESSAGE);
                return false;
            }
        }
    }
    
    // Método para limpar os campos após cadastro
    private void limparCampos() {
        view.getTxtNome().setText("");
        view.getTxtEmail().setText("");
        view.getSenha().setText("");
    }
    //Validação dos campos, fiz dessa forma para ficar mais facil de entender
    private boolean campoVazio(String campo) {
        return campo == null || campo.trim().isEmpty();
    }
    
}