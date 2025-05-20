
package Model;

import Control.SessaoUsuario;

public class Playlist {
    private String nomePlaylist;
    private Usuario usuario;
    
    public Playlist() {
    }
    
    public Playlist(String nomePlaylist) {
        this.nomePlaylist = nomePlaylist;
    }
    
    public Playlist(String nomePlaylist, Usuario usuario) {
        this.nomePlaylist = nomePlaylist;
        this.usuario = SessaoUsuario.getUsuarioLogado();
    }
    
    public String getNomePlaylist() {
        return nomePlaylist;
    }
    
    public void setNomePlaylist(String nomePlaylist) {
        this.nomePlaylist = nomePlaylist;
    }
    
    public Usuario getUsuario() {
        return usuario;
    }
    
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
