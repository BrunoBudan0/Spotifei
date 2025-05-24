
package Model;

import java.sql.Time;

public class Musica {
    private int idMusic; 
    private String nomeMusic; 
    private java.sql.Time duracaoMusic;
    private String descricaoMusic;
    private String artistaMusic;
    private String generoMusic;

    public Musica() {
    }
    
    //Pesquisa
    public Musica(String nomeMusic) {
        this.nomeMusic = nomeMusic;
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

    public Time getDuracaoMusic() {
        return duracaoMusic;
    }

    public void setDuracaoMusic(Time duracaoMusic) {
        this.duracaoMusic = duracaoMusic;
    }

    public String getArtistaMusic() {
        return artistaMusic;
    }

    public void setArtistaMusic(String artistaMusic) {
        this.artistaMusic = artistaMusic;
    }

    public String getDescricaoMusic() {
        return descricaoMusic;
    }

    public void setDescricaoMusic(String descricaoMusic) {
        this.descricaoMusic = descricaoMusic;
    }

    public String getGeneroMusic() {
        return generoMusic;
    }

    public void setGeneroMusic(String generoMusic) {
        this.generoMusic = generoMusic;
    }
    
    
    
}
