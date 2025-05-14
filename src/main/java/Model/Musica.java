
package Model;

public class Musica {
    private int idMusic; 
    private String nomeMusic; 
//    private img  foto;
    private String generoMusic;
//    private time duracaoMusic; 
    private String descricaoMusic;
//  resolver como colocar o artista

    public Musica() {
    }

    public int getIdMusic() {
        return idMusic;
    }

    public void setIdMusic(int idMusic) {
        this.idMusic = idMusic;
    }

    public String getNomeMusic() {
        return nomeMusic;
    }

    public void setNomeMusic(String nomeMusic) {
        this.nomeMusic = nomeMusic;
    }

    public String getGeneroMusic() {
        return generoMusic;
    }

    public void setGeneroMusic(String generoMusic) {
        this.generoMusic = generoMusic;
    }

    public String getDescricaoMusic() {
        return descricaoMusic;
    }

    public void setDescricaoMusic(String descricaoMusic) {
        this.descricaoMusic = descricaoMusic;
    }
    
    
    
}
