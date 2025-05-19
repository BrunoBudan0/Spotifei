
package Control;

import Model.Usuario;

public class SessaoUsuario {
    private static Usuario usuarioLogado = null;
    
    public static void setUsuarioLogado(Usuario usuario) {
        usuarioLogado = usuario;
    }
    
    public static Usuario getUsuarioLogado() {
        return usuarioLogado;
    }
    
    public static boolean isLogado() {
        return usuarioLogado != null;
    }
    
    public static void logout() {
        usuarioLogado = null;
    }
}

