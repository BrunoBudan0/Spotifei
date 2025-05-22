
package Model;

import Control.SessaoUsuario;

public class Playlist {
    private int idPlaylist;
    private String nomePlaylist;
    private Usuario usuario;
    
    public Playlist() {
    }

    public Playlist(int idPlaylist) {
        this.idPlaylist = idPlaylist;
    }
    
    public Playlist(String nomePlaylist) {
        this.nomePlaylist = nomePlaylist;
    }
    
    public Playlist(String nomePlaylist, Usuario usuario) {
        this.nomePlaylist = nomePlaylist;
        this.usuario = SessaoUsuario.getUsuarioLogado();
    }

    public Playlist(int idPlaylist, Usuario usuario) {
        this.idPlaylist = idPlaylist;
        this.usuario = usuario;
    }
    
    public Playlist(int idPlaylist, String nomePlaylist, Usuario usuario) {
        this.idPlaylist = idPlaylist;
        this.nomePlaylist = nomePlaylist;
        this.usuario = usuario;
    }

    public int getIdPlaylist() {
        return idPlaylist;
    }

    public void setIdPlaylist(int idPlaylist) {
        this.idPlaylist = idPlaylist;
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
