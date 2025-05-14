
package Model;

public class Usuario {
    private int idUsuario;
    private String nomeUsuario;
    private String emailUsuario;
    private int senhaUsuario;

    public Usuario() {
    }

    public Usuario(int idUsuario, String nomeUsuario, String emailUsuario, int senhaUsuario) {
        this.idUsuario = idUsuario;
        this.nomeUsuario = nomeUsuario;
        this.emailUsuario = emailUsuario;
        this.senhaUsuario = senhaUsuario;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public String getEmailUsuario() {
        return emailUsuario;
    }

    public void setEmailUsuario(String emailUsuario) {
        this.emailUsuario = emailUsuario;
    }

    public int getSenhaUsuario() {
        return senhaUsuario;
    }

    public void setSenhaUsuario(int senhaUsuario) {
        this.senhaUsuario = senhaUsuario;
    }

    @Override
    public String toString() {
        return "Usuario{" + "nome=" + nomeUsuario + ", email=" + emailUsuario + ", senha=" + senhaUsuario + '}';
    }
    
    
    
}
