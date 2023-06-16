/*
* Esta class ****
* */

public class Utilizador {
    private String nome;
    private String nomeUsuario;
    private String senha;
    private String contacto;

    //contrutor
    public Utilizador(String nome, String nomeUsuario,  String senha, String contacto){
        this.nome = nome;
        this.nomeUsuario = nomeUsuario;
        this.senha = senha;
        this.contacto = contacto;
    }

    //gets e sets
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getNome() {
        return nome;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }
    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    public String getSenha() {
        return senha;
    }

    public void setContacto(String contacto) {
        this.contacto = contacto;
    }
    public String getContacto() {
        return contacto;
    }
}